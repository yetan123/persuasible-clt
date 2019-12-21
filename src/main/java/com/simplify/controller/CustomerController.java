package com.simplify.controller;

import com.github.pagehelper.IPage;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simplify.model.entity.ConverCustomer;
import com.simplify.model.entity.Customer;
import com.simplify.model.entity.User;
import com.simplify.service.ConverCustomerService;
import com.simplify.service.CustomerService;
import com.simplify.service.UserService;
import com.simplify.utils.SnowFlake;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 客户控制器，负责对客户业务的分发
 * @author lanmu
 * @date 2019/12/18
 */
@Controller
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
    @ResponseBody
    public PageInfo<Customer> listCustomer(@RequestBody Map params) {
        PageInfo<Customer> pageInfo = getPageInfo(params);
        return pageInfo;
    }

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

    @GetMapping("/listConvertUser")
    @ResponseBody
    public List<User> listConvertUser(Long id) {
        return userService.listUserByNotId(id);
    }

    @PostMapping("/saveConvert")
    @ResponseBody
    public int saveConvert(@RequestBody ConverCustomer converCustomer) {
        converCustomer.setId(new SnowFlake(0,0).nextId());
        System.out.println(converCustomer);
        customerService.updateCustomerUserIdById(converCustomer.getConverUserId(), converCustomer.getReceiveUserId());
        return converCustomerService.saveConverCustomer(converCustomer);
    }

}

