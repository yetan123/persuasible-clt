package com.simplify.controller;


import com.simplify.model.dto.RecordDTO;
import com.simplify.model.entity.Customer;
import com.simplify.model.entity.CustomerRecord;
import com.simplify.service.CustomerRecordService;
import com.simplify.service.CustomerService;
import com.simplify.utils.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("CustomerRecord")
public class CustomerRecordControl {
    @Resource
    private CustomerRecordService customerRecordService;
    @Resource
    private CustomerService customerService;

    @ResponseBody
    @GetMapping("/findAllCustomerRecord")
    public List<CustomerRecord> findAllCustomerRecord(){
        List<CustomerRecord> list = customerRecordService.selectAllCustomerRecord();
        System.out.println(list);
        return list;
    }

    @ResponseBody
    @PostMapping("/updateCustomerRecord")
    public int updateCustomerRecord(@RequestBody RecordDTO record1){
        System.out.println(record1);
        CustomerRecord c1 = new CustomerRecord();
        c1.setId(record1.getId());
        c1.setRecordProgress(record1.getProcess());
        c1.setRecordContent(record1.getRecordContent());
        c1.setRecordTime(record1.getDate1());
        c1.setRecordNextTime(record1.getDate2());
        c1.setRecordType(record1.getType());
        c1.setLinkmanId(record1.getCustomer());
        c1.setCustomerId(record1.getCustomer());
        System.out.println(c1);
        return customerRecordService.updateCustomerRecord(c1);
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
        c.setId(new SnowFlake(0,0).nextId());
        c.setRecordContent(record.getRecordContent());
       c.setRecordType(record.getType());
       c.setRecordTime(record.getDate1());
       c.setRecordNextTime(record.getDate2());
       c.setRecordProgress(record.getProcess());
       c.setCustomerId(record.getCustomer());
       c.setLinkmanId(record.getCustomer());
        System.out.println(c);
         return customerRecordService.insertCustomerRecord(c);
    }
}