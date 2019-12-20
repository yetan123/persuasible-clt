package com.simplify.service;

import com.simplify.model.entity.Customer;

import java.util.List;

/***
 * 客户接口类，提供对客户的抽象方法
 * @author lanmu
 * @date 2019/12/18
 */
public interface CustomerService {
    List<Customer> listCustomer();
    Customer getCustomerById(Long id);
    /**
     * @return 全部联系人和客户
     * @author lanmu
     */
    List<Customer> listCustomerAndLinkman(Long id);
    int updateCustomerUserIdById(Long id, Long uid);
}
