package com.simplify.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simplify.model.dto.CustomerVO;
import com.simplify.model.dto.UserVO;
import com.simplify.model.entity.*;
import com.simplify.service.CustomerConverService;
import com.simplify.service.CustomerService;
import com.simplify.service.LinkmanService;
import com.simplify.service.UserService;
import com.simplify.utils.SnowFlake;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
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
    @Resource
    LinkmanService linkmanService;


    @PostMapping("/list")
    public PageInfo<CustomerVO> listCustomer(@RequestBody Map params) throws ParseException {
        String pageType = params.get("pageType").toString();
        PageInfo<CustomerVO> pageInfo = getPageInfo(filterParamsConver(params), pageType);
        PageHelper.clearPage();
        return pageInfo;
    }

    @GetMapping("/listConvertUser")
    public List<UserVO> listConvertUser(String id) {
        return userService.listUserByNotId(id);
    }

    @PostMapping("/saveConvert")
    public int saveConvert(@RequestBody CustomerConver customerConver) {
        customerService.updateCustomerUserIdById(customerConver.getCustomerId().toString(), customerConver.getReceiveUserId().toString());
        customerConver.setId(new SnowFlake(0,0).nextId());
        customerConverService.saveConverCustomer(customerConver);
        return 2;
    }

    @GetMapping("deleteCustomer")
    public int deleteCustomer(Long id) {
        return customerService.deleteCustomerById(id);
    }

    @PostMapping("saveCustomer")
    public int saveCustomer(@RequestBody Customer customer) {
        customer.setId(new SnowFlake(0, 0).nextId());
        //获取当前时间
        LocalDateTime nowTime= LocalDateTime.now();
        Date createTime = Date.from(nowTime.atZone(ZoneId.systemDefault()).toInstant());
        customer.setCreateTime(createTime);
        if(Objects.equals("",customer.getCustomerState()) || customer.getCustomerState() == null) {
            customer.setCustomerState("无状态");
        }
        int customerResult = customerService.saveCustomer(customer);

        Linkman linkman = customer.getLinkman();
        linkman.setCustomerId(customer.getId());
        linkman.setId(new SnowFlake(0, 0).nextId());
        int linkmanResult = linkmanService.saveLinkman(linkman);
        return customerResult + linkmanResult;
    }

    /**
     * 客户管理筛选数据的初始化
     * @return json
     */
    @GetMapping("/filterDataInit")
    public Map<String, List<?>> filterDataInit() {
        return listState();
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
    private PageInfo<CustomerVO> getPageInfo(Map params, String pageType) throws ParseException {
        int pageNum = 1;
        int pageSize = 4;
        List<CustomerVO> customers = null;
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
        for(CustomerVO customerVO: customers) {
            System.out.println(customerVO);
        }
        PageInfo<CustomerVO> page = new PageInfo<>(customers);
        return page;
    }

    /**
     * 获取筛选数据方法
     * @return Map
     * @author lanmu
     * @date 2019/12/21 17:30
     */
    private Map<String, List<?>> listState() {
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

    private Map filterParamsConver(Map params) throws ParseException {
        if(params.get("customerCreateDate") != null) {
            DateFormat df2 = null;
            Object createDate = params.get("customerCreateDate");
            if (createDate != null && createDate instanceof ArrayList) {
                ArrayList listDate = (ArrayList) params.get("customerCreateDate");
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                Date createStartDate = df.parse(listDate.get(0).toString());
                Date createEndDate = df.parse(listDate.get(1).toString());
                SimpleDateFormat df1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
                Date date1 = df1.parse(createStartDate.toString());
                Date date2 = df1.parse(createEndDate.toString());
                df2 = new SimpleDateFormat("yyyy-MM-dd");
                params.put("createStartDate", df2.format(date1));
                params.put("createEndDate", df2.format(date2));
            } else {
                params.put("createStartDate", null);
                params.put("createEndDate", null);
            }
        }
        return params;
    }

    @ResponseBody
    @GetMapping("selectById")
    public List<Customer> selectById(Long id){
        System.out.println(id);
        Long tid = 407157154483535872L;
        List<Customer> list = customerService.selectbyId(tid);
        System.out.println(list);
        return list;
    }
}

