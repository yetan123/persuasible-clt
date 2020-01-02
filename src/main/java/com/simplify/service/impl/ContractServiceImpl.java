package com.simplify.service.impl;

import com.simplify.mapper.ContractMapper;
import com.simplify.model.dto.ContractVO;
import com.simplify.model.entity.Contract;
import com.simplify.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
    public int deleteContractByContractCode(String id) {
        return contractMapper.deleteContractByContractCode(id);
    }

    @Override
    public int insertContract(ContractVO contractvo) {
        return contractMapper.insertContract(contractvo);
    }

    @Override
    public int updateContract(ContractVO contractVO) {
        return contractMapper.updateContract(contractVO);
    }

    @Override
    public ContractVO getContractByCode(String code) {
        return contractMapper.getContractByCode(code);
    }
}
