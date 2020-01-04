package com.simplify.service;

import com.simplify.model.entity.Customer;
import com.simplify.model.entity.CustomerRecord;
import com.simplify.model.entity.CustomerTasks;

import java.util.List;

public interface CustomerRecordService {
    List<CustomerRecord> selectAllCustomerRecord();

    int insertCustomerRecord(CustomerRecord customerRecord);

    int deleteCustomerRecord(Long id);

    int updateCustomerRecord(CustomerRecord customerRecord);
}
