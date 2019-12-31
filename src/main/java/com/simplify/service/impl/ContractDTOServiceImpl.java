package com.simplify.service.impl;

import com.simplify.mapper.ContractDTOMapper;
import com.simplify.model.entity.*;
import com.simplify.service.ContractDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDTOServiceImpl implements ContractDTOService {

    @Autowired
    private ContractDTOMapper contractDTOMapper;

    @Override
    public List<Customer> listCustomerIDAndCustomerName() {
        return contractDTOMapper.listCustomerIDAndCustomerName();
    }

    @Override
    public List<Linkman> getLinkmanByCustomerId(Long CustomerId) {
        return contractDTOMapper.getLinkmanByCustomerId(CustomerId);
    }

    @Override
    public List<Business> listBusiness() {
        return contractDTOMapper.listBusiness();
    }

    @Override
    public List<ContractType> listContractType() {
        return contractDTOMapper.listContractType();
    }

    @Override
    public List<ContractState> listContractState() {
        return contractDTOMapper.listContractState();
    }

    @Override
    public List<User> listUser() {
        return contractDTOMapper.listUser();
    }
}
