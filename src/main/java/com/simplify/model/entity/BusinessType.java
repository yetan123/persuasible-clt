package com.simplify.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 商机类型表实体类
 * @author 杨泓
 * @date 2019-12-25
 */
@Table(name="tb_business_type")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessType {
    @Id
    private Long id;
    private String businessType;
}
