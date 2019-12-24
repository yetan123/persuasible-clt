package com.simplify.controller;


import com.simplify.model.dto.RecordDTO;
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

    @ResponseBody
    @GetMapping("/deleteCustomerRecord")
    public int deleteCustomerRecord(Long id){
        return customerRecordService.deleteCustomerRecord(id);
    }

    @ResponseBody
    @PostMapping("/insertCustomerRecord")
    public int insertCustomerRecord(@RequestBody RecordDTO record){
        System.out.println(record);
        CustomerRecord c = new CustomerRecord();
        c.setRecordContent(record.getRecordContent());
       c.setRecordType(record.getType());
       c.setRecordTime(record.getDate1());
       c.setRecordNextTime(record.getDate2());
       c.setRecordProgress(record.getProcess());
       c.setCustomerId(record.getCustomer());
       c.setLinkmanId(record.getCustomer());
         return customerRecordService.insertCustomerRecord(c);
    }
}