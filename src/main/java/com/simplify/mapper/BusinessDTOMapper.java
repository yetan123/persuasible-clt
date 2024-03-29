package com.simplify.mapper;

import com.simplify.model.entity.*;
import com.simplify.model.vo.BusinessCustomerVO;
import com.simplify.model.vo.BusinessLinkmanVO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusinessDTOMapper {

    @Select("select ID,COMPANY_NAME from TB_CUSTOMER")
    @Results({
            @Result(column = "ID",property = "id",id = true),
            @Result(column = "COMPANY_NAME",property = "companyName")
    })
    List<BusinessCustomerVO> listCustomerIDAndCustomerName();


    @Select("select l.ID,l.CUSTOMER_NAME from TB_LINKMAN l inner join TB_CUSTOMER c on l.CUSTOMER_ID = c.ID where c.ID = #{CustomerId}")
    @Results({
            @Result(column = "ID",property = "id",id = true),
            @Result(column = "CUSTOMER_NAME",property = "customerName")
    })
    List<BusinessLinkmanVO> getLinkmanByCustomerId(Long CustomerId);

    @Select("select * from TB_BUSINESS_TYPE")
    @Results({
            @Result(column = "id",property = "id",id = true),
            @Result(column = "BUSINESS_TYPE",property = "businessType")
    })
    List<BusinessType> listBusinessType();

    @Select("select * from TB_BUSINESS_SOURCE")
    @Results({
            @Result(column = "id",property = "id",id = true),
            @Result(column = "BUSINESS_SOURCE",property = "businessSource")
    })
    List<BusinessSource> listBusinessSource();

    @Select("SELECT ID,USERNAME from TB_USER")
    @Results({
            @Result(column = "ID",property = "id",id = true),
            @Result(column = "USERNAME",property = "username")
    })
    List<User> listUser();

}
