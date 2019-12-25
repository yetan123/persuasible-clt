package com.simplify.service.impl;

import com.simplify.mapper.CustomerMapper;
import com.simplify.model.entity.*;
import com.simplify.service.CustomerService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/***
 * 客户业务接口实现类
 * @author lanmu
 * @date 2019/12/18
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Resource
    CustomerMapper customerMapper;

    @CacheEvict(value = {"customerAndLinkman"})
    @Override
    public int deleteCustomerById(Long id) {
        return customerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Customer> listCustomer() {
        return customerMapper.selectAll();
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value = "customerAndLinkman")
    @Override
    public List<Customer> listCustomerAndLinkman(Map map) {
        return customerMapper.listCustomerAndLinkman(map);
    }


    @Cacheable(value = "converToMe")
    @Override
    public List<Customer> listConverToMe(Map params) {
        return customerMapper.listConverToMe(params);
    }

    @CacheEvict(value = {"customerAndLinkman","converToMe","conver"})
    @Override
    public int updateCustomerUserIdById(Long id, Long uid) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setUserId(uid);
        return customerMapper.updateByPrimaryKeySelective(customer);
    }

    @Override
    public int saveCustomer(Customer customer) {
        System.out.println(customer);
        return customerMapper.insert(customer);
    }

    @Cacheable(value = "conver")
    @Override
    public List<Customer> listConver(Map params) {
        return customerMapper.listConver(params);
    }

    @Cacheable(value = "sources")
    @Override
    public List<CustomerSource> listCustomerSource() {
        return customerMapper.listCustomerSource();
    }

    @Cacheable(value = "categorys")
    @Override
    public List<CustomerCategory> listCustomerCategory() {
        return customerMapper.listCustomerCategory();
    }

    @Cacheable(value = "states")
    @Override
    public List<CustomerState> listCustomerState() {
        return customerMapper.listCustomerState();
    }

    @Cacheable(value = "ranks")
    @Override
    public List<CustomerRank> listCustomerRank() {
        return customerMapper.listCustomerRank();
    }

    @Override
    public List<Customer> selectbyId(Long id) {
        Example example = new Example(Customer.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", id);
        return customerMapper.selectByExample(example);
    }
}
