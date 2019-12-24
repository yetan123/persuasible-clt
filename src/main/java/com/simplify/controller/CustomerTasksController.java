package com.simplify.controller;


import com.simplify.model.entity.CustomerTasks;
import com.simplify.service.CustomerTasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("CustomerTasks")
public class CustomerTasksController {
    @Autowired
    private CustomerTasksService customerTasksService;

    @ResponseBody
    @RequestMapping("/findAllCustomerTasks")
    public List<CustomerTasks> findAllCustomerTasks(){
        return customerTasksService.selectAllTasksCustomerTasks();
    }


    @ResponseBody
    @GetMapping("/deleteCustomerTasks")
    public int deleteCustomerTasks(Long id){
        return customerTasksService.deleteCustomerTasks(id);
    }
}
