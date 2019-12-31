package com.simplify.service;

import com.simplify.model.dto.ContractVO;
import com.simplify.model.entity.Contract;

import java.util.List;

public interface ContractService {

    List<Contract> listContract();

    List<Contract> listContractById(Long id);

    void deleteContractByContractCode(String contractCode);

    int insertContract(ContractVO contractVO);

    int updateContract(ContractVO contractVO);
}
