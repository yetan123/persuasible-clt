package com.simplify.mapper;

import com.simplify.model.entity.Customer;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 客户映射层
 * @author lanmu
 * @date 2019/12/18
 */
@Repository
public interface CustomerMapper extends Mapper<Customer> {
    /**
     * @return 全部联系人和客户
     */
    List<Customer> listCustomerAndLinkman(Map params);
    Long listCountCustomerAndLinkman(Map params);
}
