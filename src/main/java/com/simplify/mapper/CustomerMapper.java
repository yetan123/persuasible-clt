package com.simplify.mapper;

import com.simplify.model.dto.CustomerVO;
import com.simplify.model.entity.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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
    List<CustomerVO> listCustomerAndLinkman(Map params);
    List<CustomerVO> listConver(Map params);
    List<CustomerVO> listConverToMe(Map params);

    @Update("update tb_customer SET USER_ID=#{receiveUserId} WHERE ID='${targetCustomerId}' ")
    int updateCustomerUserIdById(@Param("targetCustomerId") String id, @Param("receiveUserId") String receiveUserId);


    /**
     * 筛选返回的json数据
     */
    @Select("select * from TB_SOURCE")
    List<CustomerSource> listCustomerSource();
    @Select("select * from TB_CUSTOMER_CATEGORY")
    List<CustomerCategory> listCustomerCategory();
    @Select("select * from TB_CUSTOMER_STATE")
    List<CustomerState> listCustomerState();
    @Select("select * from TB_CUSTOMER_RANK")
    List<CustomerRank> listCustomerRank();
}
