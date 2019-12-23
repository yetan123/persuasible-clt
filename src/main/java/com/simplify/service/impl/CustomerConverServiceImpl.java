package com.simplify.service.impl;

import com.simplify.mapper.CustomerConverMapper;
import com.simplify.model.entity.CustomerConver;
import com.simplify.service.CustomerConverService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerConverServiceImpl implements CustomerConverService {
    @Resource
    CustomerConverMapper customerConverMapper;

    @Override
    public int saveConverCustomer(CustomerConver customerConver) {
        System.out.println(customerConver);
        return customerConverMapper.insert(customerConver);
    }

    @Override
    public CustomerConver findCustomerConverByUserId(Long id) {
        return customerConverMapper.findCustomerConverByUserId(id);
    }
}
