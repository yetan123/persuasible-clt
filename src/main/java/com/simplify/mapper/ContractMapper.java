package com.simplify.mapper;

import com.simplify.model.dto.ContractVO;
import com.simplify.model.entity.Contract;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface ContractMapper extends Mapper<ContractVO> {

       List<ContractVO> listContract();

       List<ContractVO> listContractById(String id);

       void deleteContractByContractCode(String contractCode);
}
