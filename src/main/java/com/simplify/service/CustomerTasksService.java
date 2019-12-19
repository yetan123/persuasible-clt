package com.simplify.service;

import com.simplify.model.entity.CustomerTasks;


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
}