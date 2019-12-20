package com.simplify.service.impl;

import com.simplify.mapper.CustomerRecordMapper;
import com.simplify.model.entity.CustomerRecord;
import com.simplify.model.entity.CustomerRecord;
import com.simplify.service.CustomerRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerRecordServiceImpl implements CustomerRecordService {
    @Autowired
    private CustomerRecordMapper customerRecordMapper;


    @Override
    public List<CustomerRecord> selectAllCustomerRecord() {
        return customerRecordMapper.selectAllCustomerRecord();
    }

    @Override
    public int insertCustomerRecord(CustomerRecord customerRecord) {
        int i = customerRecordMapper.insert(customerRecord);
        return i;
    }

    @Override
    public int deleteCustomerRecord(int id) {
        int i = customerRecordMapper.deleteByPrimaryKey(id);
        return i;
    }

    @Override
    public int updateCustomerRecord(CustomerRecord customerRecord) {
        int i = customerRecordMapper.updateByPrimaryKeySelective(customerRecord);
        return i;
    }
}
