package com.simplify.service.impl;

import com.simplify.mapper.CustomerMapper;
import com.simplify.model.dto.CustomerVO;
import com.simplify.model.entity.*;
import com.simplify.service.CustomerService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.RollbackException;
import java.util.List;
import java.util.Map;

/***
 * 客户业务接口实现类
 * @author lanmu
 * @date 2019/12/18
 */
@Service
@Transactional(rollbackFor = {RollbackException.class})
public class CustomerServiceImpl implements CustomerService {
    @Resource
    CustomerMapper customerMapper;

    @CacheEvict(value = {"customerAndLinkman","converToMe","conver"}, allEntries = true)
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
    public List<CustomerVO> listCustomerAndLinkman(Map map) {
        return customerMapper.listCustomerAndLinkman(map);
    }


    @Cacheable(value = "converToMe")
    @Override
    public List<CustomerVO> listConverToMe(Map params) {
        return customerMapper.listConverToMe(params);
    }

    @CacheEvict(value = {"customerAndLinkman","converToMe","conver"}, allEntries = true)
    @Override
    public int updateCustomerUserIdById(String id, String uid) {
        return customerMapper.updateCustomerUserIdById(id, uid);
    }

    @Override
    @CacheEvict(value = {"customerAndLinkman","converToMe","conver"}, allEntries = true)
    public int saveCustomer(Customer customer) {
        return customerMapper.insertSelective(customer);
    }

    @Cacheable(value = "conver")
    @Override
    public List<CustomerVO> listConver(Map params) {
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
    public List<CustomerVO> selectByID(String id) {
        return customerMapper.selectByID(id);
    }

    @Override
    public List<Customer> selectALL() {
        return customerMapper.selectAll();
    }

}
