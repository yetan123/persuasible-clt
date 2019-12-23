package com.simplify.mapper;

import com.simplify.model.entity.CustomerConver;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface CustomerConverMapper extends Mapper<CustomerConver> {
    @Select("select * from tb_customer_conver where customer_id = #{0}")
    CustomerConver findCustomerConverByUserId(Long id);
}
