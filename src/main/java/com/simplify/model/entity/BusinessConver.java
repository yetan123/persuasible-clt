package com.simplify.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 商机交易表实体类
 * @author 杨泓
 * @date 2019-12-25
 */
@Table(name="tb_business_conver")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessConver {
    @Id
    private Long id;
    private Long businessId;
    private Long originalUserId;
    private Long currentUserId;
    private String converTime;
    private User user;
    private Business business;
    private Customer customer;


}
