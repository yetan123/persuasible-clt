package com.simplify.mapper;

import com.simplify.model.dto.ContractDTO;
import com.simplify.model.entity.*;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface ContractDTOMapper  {

    //客户查询
    @Select("select ID,COMPANY_NAME from TB_CUSTOMER")
    @Results({
            @Result(column = "ID",property = "id",id = true),
            @Result(column = "COMPANY_NAME",property = "companyName")
    })
    List<Customer> listCustomerIDAndCustomerName();

    @Select("select l.ID,l.CUSTOMER_NAME from TB_LINKMAN l inner join TB_CUSTOMER c on l.CUSTOMER_ID = c.ID where c.ID = #{CustomerId}")
    @Results({
            @Result(column = "ID",property = "id",id = true),
            @Result(column = "CUSTOMER_NAME",property = "customerName")
    })
    Linkman getLinkmanByCustomerId(Long CustomerId);

    @Select("select ID,BUSINESS_NAME from TB_BUSINESS")
    @Results({
            @Result(column = "ID",property = "id",id = true),
            @Result(column = "BUSINESS_NAME",property = "businessName")
    })
    List<Business> listBusiness();

    @Select("SELECT ID,CONTRACT_TYPE from TB_CONTRACT_TYPE")
    @Results({
            @Result(column = "ID",property = "id",id = true),
            @Result(column = "CONTRACT_TYPE",property = "contractType")
    })
    List<ContractType> listContractType();

    @Select("SELECT ID,CONTRACT_STATE from TB_CONTRACT_STATE")
    @Results({
            @Result(column = "ID",property = "id",id = true),
            @Result(column = "CONTRACT_STATE",property = "contractState")
    })
    List<ContractState> listContractState();

    @Select("SELECT ID,USERNAME from TB_USER")
    @Results({
            @Result(column = "ID",property = "id",id = true),
            @Result(column = "USERNAME",property = "username")
    })
    List<User> listUser();
}
