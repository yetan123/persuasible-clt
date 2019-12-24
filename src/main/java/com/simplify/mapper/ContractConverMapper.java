package com.simplify.mapper;

import com.simplify.model.entity.ContractConver;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface ContractConverMapper extends Mapper<ContractConver> {

    List<ContractConver> listConvertMe(Long receiveUserId);

    List<ContractConver> listMeConvert(Long converUserId);
}
