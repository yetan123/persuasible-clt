package com.simplify.service.impl;

import com.simplify.mapper.ContractConverMapper;
import com.simplify.model.entity.ContractConver;
import com.simplify.service.ContractConverService;
import com.simplify.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContractConverServiceImpl implements ContractConverService {

    @Autowired
    private ContractConverMapper contractConverMapper;

    @Override
    public List<ContractConver> listConvertMe(Long receiveUserId) {
        return contractConverMapper.listConvertMe(receiveUserId);
    }

    @Override
    public List<ContractConver> listMeConvert(Long converUserId) {
        return contractConverMapper.listMeConvert(converUserId);
    }
}
