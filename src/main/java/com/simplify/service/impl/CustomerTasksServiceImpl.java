package com.simplify.service.impl;

import com.simplify.mapper.CustomerTasksMapper;
import com.simplify.model.entity.CustomerTasks;
import com.simplify.service.CustomerTasksService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CustomerTasksServiceImpl implements CustomerTasksService {
    @Resource
    CustomerTasksMapper customerTasksMapper;

    @Override
    public CustomerTasks getCustomerTasksByCustomerId(Long customerId) {
        return customerTasksMapper.getCustomerTasksByCustomerId(customerId);
    }
}
