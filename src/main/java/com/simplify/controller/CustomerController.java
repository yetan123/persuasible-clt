package com.simplify.controller;

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

    @GetMapping("/list")
    @ResponseBody
    public List<Customer> listCustomer(Long id) {
        System.out.println("login of id is " + id);
        return customerService.listCustomerAndLinkman(id);
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

