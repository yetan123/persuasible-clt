package com.simplify.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 商机表实体类
 * @author 杨泓
 * @date 2019-12-17
 */

@Table(name="tb_business")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Business {
    @Id
    private Long id;

    private String business_Name;

    private Double estimated_Sales;

    private String estimated_Date;

    private Double estimated_Success;

    private String customer_Decision;

    private String find_Date;

    private String business_Description;

    private Long user_Id;

    private Long business_Source_Id;

    private Long customer_Id;

    private String business_Type;

    private String business_Phases;

    private Integer business_States;

    private String create_Time;


}
