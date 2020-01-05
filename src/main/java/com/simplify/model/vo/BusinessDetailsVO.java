package com.simplify.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * 商机详情信息
 * @author yuntian
 * @date 2020-1-3
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessDetailsVO {
    private String id;

    private String businessName;

    private String estimatedSales;

    private Date estimatedDate;

    private Double estimatedSuccess;

    private Date findDate;

    private String businessDescription;

    private String businessPhases;

    private BusinessDetailsCustomerVO businessDetailsCustomerVO;

    private String username;

    private Date createTime;

    private String businessType;

    private String businessSource;

    private Integer businessState;

}
