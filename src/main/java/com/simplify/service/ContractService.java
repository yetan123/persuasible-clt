package com.simplify.service;

import com.simplify.model.dto.ContractVO;
import com.simplify.model.entity.Contract;

import java.util.List;

public interface ContractService {

    List<ContractVO> listContract();

    List<ContractVO> listContractById(String id);

    void deleteContractByContractCode(String contractCode);
}
