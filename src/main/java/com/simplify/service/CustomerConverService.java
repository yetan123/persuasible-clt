package com.simplify.service;

import com.simplify.model.entity.CustomerConver;

import java.util.List;

public interface CustomerConverService {
    int saveConverCustomer(CustomerConver customerConver);
    CustomerConver findCustomerConverByUserId(Long id);
}
