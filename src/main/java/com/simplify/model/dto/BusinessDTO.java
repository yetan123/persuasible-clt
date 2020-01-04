package com.simplify.model.dto;

import com.simplify.model.entity.*;
import com.simplify.model.vo.BusinessCustomerVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 商机相关下拉框信息
 * @author yuntian
 * @date 2020-1-1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessDTO {
    private List<BusinessCustomerVO> customer;
    private List<BusinessType> businessType;
    private List<BusinessSource> businessSource;
}
