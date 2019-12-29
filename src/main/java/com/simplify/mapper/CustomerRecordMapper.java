package com.simplify.mapper;

import com.simplify.model.entity.Customer;
import com.simplify.model.entity.CustomerRecord;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author water
 * @date 2019-12-18
 */
@Repository
public interface CustomerRecordMapper extends Mapper<CustomerRecord> {
    List<CustomerRecord> selectAllCustomerRecord();

    int insertCustomerRecord(CustomerRecord customerRecord);

}
