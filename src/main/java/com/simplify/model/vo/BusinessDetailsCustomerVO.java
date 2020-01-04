package com.simplify.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 封装商机详情信息与客户的信息
 * @author yuntian
 * @date 2020-1-3
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessDetailsCustomerVO {
    private String companyName;

    private String customerName;
}
