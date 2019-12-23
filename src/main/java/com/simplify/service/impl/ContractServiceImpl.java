package com.simplify.service.impl;

import com.simplify.mapper.ContractMapper;
import com.simplify.model.entity.Contract;
import com.simplify.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractMapper contractMapper;

    @Override
    public List<Contract> listContract() {
        return contractMapper.listContract();
    }

    @Override
    public List<Contract> listContractById(Long id) {
        return contractMapper.listContractById(id);
    }

    @Override
    public void deleteContractByContractCode(String contractCode) {
        contractMapper.deleteContractByContractCode(contractCode);
    }
}
