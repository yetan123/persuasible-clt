package com.simplify.mapper;

import com.simplify.model.dto.ContractVO;
import com.simplify.model.entity.Contract;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface ContractMapper extends Mapper<Contract> {

       List<Contract> listContract();

       List<Contract> listContractById(Long id);

       int deleteContractByContractCode(String id);

       int insertContract(ContractVO contractVO);

       int updateContract(ContractVO contractVO);

       ContractVO getContractByCode(String code);
}
