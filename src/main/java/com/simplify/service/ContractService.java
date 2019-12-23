package com.simplify.service;

import com.simplify.model.entity.Contract;

import java.util.List;

public interface ContractService {

    List<Contract> listContract();

    List<Contract> listContractById(Long id);

    void deleteContractByContractCode(String contractCode);
}
