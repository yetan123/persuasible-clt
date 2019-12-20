package com.simplify.controller;

import com.simplify.model.entity.ConvertCustomer;
import com.simplify.model.entity.Customer;
import com.simplify.model.entity.User;
import com.simplify.service.CustomerService;
import com.simplify.service.LinkmanService;
import com.simplify.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

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

    @GetMapping("/list")
    @ResponseBody
    public List<Customer> listCustomer() {
        return customerService.listCustomerAndLinkman();
    }

    @GetMapping("/listConvertUser")
    @ResponseBody
    public List<User> listConvertUser() {
        return userService.findAll();
    }

    @GetMapping("/saveConvert")
    @ResponseBody
    public int saveConvert(@RequestBody ConvertCustomer convertCustomer) {
        return 0;
    }
}

