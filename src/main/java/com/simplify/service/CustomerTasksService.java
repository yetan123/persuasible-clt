package com.simplify.service;

import com.simplify.model.entity.CustomerRecord;
import com.simplify.model.entity.CustomerTasks;

import java.util.List;


public interface CustomerTasksService {

    /**
     * 根据一个客户ID获取跟进任务
     *
     * @param customerId
     * @return CustomerTasks
     * @author lanmu
     * @date 2019/12/18
     */
    CustomerTasks getCustomerTasksByCustomerId(Long customerId);

    int insertCustomerTasks(CustomerTasks customerTasks);

    List<CustomerTasks> selectAllTasksCustomerTasks();

    int deleteCustomerTasks(Long i);

    int updateCustomerTasks(CustomerTasks customerTasks);
}