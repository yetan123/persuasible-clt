package com.simplify.service.impl;

import com.simplify.mapper.CustomerMapper;
import com.simplify.model.entity.Customer;
import com.simplify.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/***
 * 客户业务接口实现类
 * @author lanmu
 * @date 2019/12/18
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Resource
    CustomerMapper customerMapper;


    @Override
    public List<Customer> listCustomer() {
        return customerMapper.selectAll();
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Customer> listCustomerAndLinkman() {
        return customerMapper.listCustomerAndLinkman();
    }
}
