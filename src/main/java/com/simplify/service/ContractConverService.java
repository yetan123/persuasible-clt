package com.simplify.service;

import com.simplify.model.entity.ContractConver;

import java.util.List;

public interface ContractConverService {

    List<ContractConver> listConvertMe(Long receiveUserId);

    List<ContractConver> listMeConvert(Long converUserId);
}
