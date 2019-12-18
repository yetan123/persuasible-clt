package com.simplify.mapper;

import com.simplify.model.entity.Customer;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * 客户映射层
 * @author lanmu
 * @date 2019/12/18
 */
@Repository
public interface CustomerMapper extends Mapper<Customer> {
}
