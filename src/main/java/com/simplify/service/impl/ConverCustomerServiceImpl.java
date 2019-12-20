package com.simplify.service.impl;

import com.simplify.mapper.ConverCustomerMapper;
import com.simplify.model.entity.ConverCustomer;
import com.simplify.service.ConverCustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ConverCustomerServiceImpl implements ConverCustomerService {
    @Resource
    ConverCustomerMapper converCustomerMapper;

    @Override
    public int saveConverCustomer(ConverCustomer converCustomer) {
        System.out.println(converCustomer);
        return converCustomerMapper.insert(converCustomer);
    }
}
