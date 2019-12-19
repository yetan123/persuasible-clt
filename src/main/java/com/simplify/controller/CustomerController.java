package com.simplify.controller;

import com.simplify.model.entity.Customer;
import com.simplify.service.CustomerService;
import com.simplify.service.LinkmanService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("/list")
    @ResponseBody
    public List<Customer> listCustomer() {
        return customerService.listCustomerAndLinkman();
    }
}
