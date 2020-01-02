package com.simplify.service.impl;

import com.simplify.mapper.CustomerTasksMapper;
import com.simplify.model.entity.CustomerRecord;
import com.simplify.model.entity.CustomerTasks;
import com.simplify.service.CustomerTasksService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerTasksServiceImpl implements CustomerTasksService {
    @Resource
    CustomerTasksMapper customerTasksMapper;

    @Override
    public CustomerTasks getCustomerTasksByCustomerId(Long customerId) {
        return customerTasksMapper.getCustomerTasksByCustomerId(customerId);
    }

    @Override
    public int insertCustomerTasks(CustomerTasks customerTasks) {
        return customerTasksMapper.insertCustomerTasks(customerTasks);
    }

    @Override
    public List<CustomerTasks> selectAllTasksCustomerTasks() {
        return customerTasksMapper.selectAllTasksCustomerTasks();
    }

    @Override
    public int deleteCustomerTasks(Long i) {
        return customerTasksMapper.deleteByPrimaryKey(i);
    }

    @Override
    public int updateCustomerTasks(CustomerTasks customerTasks) {
        return customerTasksMapper.updateByPrimaryKeySelective(customerTasks);
    }
}
