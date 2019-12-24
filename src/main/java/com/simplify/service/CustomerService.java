package com.simplify.service;

import com.simplify.model.entity.*;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

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
    List<Customer> listCustomerAndLinkman(Map params);
    List<Customer> listConverToMe(Map params);

    /**
     * 更改l客户负责人
     * @param id
     * @param uid
     * @return
     */
    int updateCustomerUserIdById(Long id, Long uid);
    int deleteCustomerById(Long id);
    List<Customer> listConver(Map params);

    List<CustomerSource> listCustomerSource();
    List<CustomerCategory> listCustomerCategory();
    List<CustomerState> listCustomerState();
    List<CustomerRank> listCustomerRank();
}
