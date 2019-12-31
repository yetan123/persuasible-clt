package com.simplify.service;

import com.simplify.model.entity.*;

import java.util.List;

public interface ContractDTOService {

    List<Customer> listCustomerIDAndCustomerName();

    List<Linkman> getLinkmanByCustomerId(Long CustomerId);

    List<Business> listBusiness();

    List<ContractType> listContractType();

    List<ContractState> listContractState();

    List<User> listUser();
}
