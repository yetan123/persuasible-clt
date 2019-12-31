package com.simplify.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.util.List;

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
    private String businessName;
    private Long estimatedSales;
    private Date estimatedDate;
    private Double estimatedSuccess;
    private String customerDecision;
    private Date findDate;
    private String businessDescription;
    private Long userId;
    private Long businessSourceId;
    private Long customerId;
    private String businessType;
    private String businessPhases;
    private Integer businessState;
    private Date createTime;
    private User user;
    private Customer customer;

//    public Double getEstimatedSuccess() {
//        estimatedSuccess=estimatedSuccess*100;
//        return estimatedSuccess;
//    }

}
