package com.simplify.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simplify.model.entity.*;
import com.simplify.service.CustomerConverService;
import com.simplify.service.CustomerService;
import com.simplify.service.UserService;
import com.simplify.utils.SnowFlake;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 客户控制器，负责对客户业务的分发
 * @author lanmu
 * @date 2019/12/18
 */
@RestController
@RequestMapping("customer")
@CrossOrigin
public class CustomerController {
    @Resource
    CustomerService customerService;
    @Resource
    UserService userService;
    @Resource
    CustomerConverService customerConverService;

    /**
     * 我的客户分页方法
     * @param params
     * @return
     */
    @PostMapping("/list")
    public PageInfo<Customer> listCustomer(@RequestBody Map params) throws ParseException {
        PageInfo<Customer> pageInfo = getPageInfo(filterParamsConver(params), params.get("pageType").toString());
        return pageInfo;
    }



    @GetMapping("/listConvertUser")
    public List<User> listConvertUser(Long id) {
        return userService.listUserByNotId(id);
    }

    @PostMapping("/saveConvert")
    public int saveConvert(@RequestBody CustomerConver customerConver) {
        customerConver.setId(new SnowFlake(0,0).nextId());
        customerService.updateCustomerUserIdById(customerConver.getCustomerId(), customerConver.getReceiveUserId());
        return customerConverService.saveConverCustomer(customerConver);
    }

    @GetMapping("deleteCustomer")
    public int deleteCustomer(Long id) {
        return customerService.deleteCustomerById(id);
    }


    /**
     * 客户管理筛选数据的初始化
     * @return json
     */
    @GetMapping("/filterDataInit")
    public Map<String, List<?>> filterDataInit() {
        return getFilterData();
    }

    /**
     * 获取分页信息
     * @param params: 前端发送过来的参数
     * pageType:用什么页面获取分页这里用来判断调用什么方法。
     * 客户管理一共三个页面：我的客户,我转交的,转交我的
     * 名称对应客户管理三个用来显示数据.vue文件
     * @return pageInfo
     * @auhor lanmu
     * @date 2019/12/21 17:29
     */
    private PageInfo<Customer> getPageInfo(Map params, String pageType) {
        int pageNum = 1;
        int pageSize = 4;
        List<Customer> customers = null;
        if(params.get("pageNum") != null) {
            pageNum = (Integer) params.get("pageNum");
        }
        if(params.get("pageSize") != null) {
            pageSize = (Integer) params.get("pageSize");
        }
        PageHelper.startPage(pageNum, pageSize, true);
        // 我的客户
        if("my".equals(pageType)) {
            System.out.println("my");
            customers = customerService.listCustomerAndLinkman(params);
            // 我转交的
        } else if("i_pass".equals(pageType)) {
            System.out.println("i_pass");
            customers = customerService.listConver(params);
        } else if("pass_me".equals(pageType)) {
            System.out.println("pass_me");
            customers = customerService.listConverToMe(params);
        } else {
            throw new RuntimeException("沒有指定分頁參數頁面");
        }
        PageInfo<Customer> page = new PageInfo<>(customers);
        return page;
    }

    /**
     * 获取筛选数据方法
     * @return Map
     * @author lanmu
     * @date 2019/12/21 17:30
     */
    public Map<String, List<?>> getFilterData() {
        Map<String, List<?>> filterDataMap = new HashMap<>();
        List<CustomerCategory> customerCategories = customerService.listCustomerCategory();
        List<CustomerRank> customerRanks = customerService.listCustomerRank();
        List<CustomerState> customerStates = customerService.listCustomerState();
        List<CustomerSource> customerSources = customerService.listCustomerSource();
        filterDataMap.put("categorys", customerCategories);
        filterDataMap.put("ranks", customerRanks);
        filterDataMap.put("states", customerStates);
        filterDataMap.put("sources", customerSources);
        return filterDataMap;
    }

    public Map filterParamsConver(Map params) throws ParseException {
        if(params.get("customerCreateDate") != null) {
            ArrayList listDate = (ArrayList) params.get("customerCreateDate");
            DateFormat df2 = null;
            if (listDate != null) {
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                Date createStartDate = df.parse(listDate.get(0).toString());
                Date createEndDate = df.parse(listDate.get(1).toString());
                SimpleDateFormat df1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
                Date date1 = df1.parse(createStartDate.toString());
                Date date2 = df1.parse(createEndDate.toString());
                df2 = new SimpleDateFormat("yyyy-MM-dd");
                params.put("createStartDate", df2.format(date1));
                params.put("createEndDate", df2.format(date2));
            }
        }
        return params;
    }
}

