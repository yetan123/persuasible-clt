package com.simplify.controller;


import com.simplify.model.entity.CustomerRecord;
import com.simplify.service.CustomerRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("CustomerRecord")
public class CustomerRecordControl {
    @Autowired
    private CustomerRecordService customerRecordService;

    @ResponseBody
    @GetMapping("/findAllCustomerRecord")
    public List<CustomerRecord> findAllCustomerRecord(){
        List<CustomerRecord> list = customerRecordService.selectAllCustomerRecord();
        System.out.println(list);
        return list;
    }
}