package com.simplify.controller;

import com.github.pagehelper.IPage;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simplify.model.entity.*;
import com.simplify.service.ConverCustomerService;
import com.simplify.service.CustomerService;
import com.simplify.service.UserService;
import com.simplify.utils.SnowFlake;
import org.springframework.stereotype.Controller;
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
    ConverCustomerService converCustomerService;

    /**
     * 我的客户分页方法
     * @param params
     * @return
     */
    @PostMapping("/list")
    public PageInfo<Customer> listCustomer(@RequestBody Map params) throws ParseException {
        PageInfo<Customer> pageInfo = getPageInfo(filterParamsConver(params));
        return pageInfo;
    }



    @GetMapping("/listConvertUser")
    public List<User> listConvertUser(Long id) {
        return userService.listUserByNotId(id);
    }

    @PostMapping("/saveConvert")
    public int saveConvert(@RequestBody ConverCustomer converCustomer) {
        converCustomer.setId(new SnowFlake(0,0).nextId());
        customerService.updateCustomerUserIdById(converCustomer.getConverUserId(), converCustomer.getReceiveUserId());
        return converCustomerService.saveConverCustomer(converCustomer);
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
     * @param params
     * @return pageInfo
     * @auhor lanmu
     * @date 2019/12/21 17:29
     */
    private PageInfo<Customer> getPageInfo(Map params) {
        int pageNum = 1;
        int pageSize = 4;
        if(params.get("pageNum") != null) {
            pageNum = (Integer) params.get("pageNum");
        }
        if(params.get("pageSize") != null) {
            pageSize = (Integer) params.get("pageSize");
        }

        PageHelper.startPage(pageNum, pageSize, true);
        List<Customer> customers = customerService.listCustomerAndLinkman(params);
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

