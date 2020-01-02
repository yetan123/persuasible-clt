package com.simplify.service;

import com.simplify.model.entity.*;

import java.util.List;

public interface BusinessDTOService {

    List<Customer> listCustomerIDAndCustomerName();
    List<Linkman> getLinkmanByCustomerId(Long CustomerId);
    List<BusinessType> listBusinessType();
    List<BusinessSource> listBusinessSource();
    List<User> listUser();
}
