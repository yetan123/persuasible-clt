package com.simplify.mapper;

import com.simplify.model.entity.CustomerTasks;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface CustomerTasksMapper extends Mapper<CustomerTasks> {
    /**
     * 根据一个客户ID获取跟进任务
     *
     * @param customerId
     * @return CustomerTasks
     * @author lanmu
     * @date 2019/12/18
     */
    @Select("select * from TB_CUSTOMER_TASKS where CUSTOMER_ID = #{0}")
    CustomerTasks getCustomerTasksByCustomerId(Long customerId);
}
