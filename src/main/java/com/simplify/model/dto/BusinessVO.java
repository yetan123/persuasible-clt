package com.simplify.model.dto;

import com.simplify.model.entity.Customer;
import com.simplify.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Table(name="tb_business")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessVO {
    @Id
    private Long id;
    private String businessName;
    private String estimatedSales;
    private Date estimatedDate;
    private Double estimatedSuccess;
    private String customerDecision;
    private Date findDate;
    private String businessDescription;
    private String userId;
    private String linkmanId;
    private String businessSourceId;
    private String customerId;
    private String businessTypeId;
    private String businessType;
    private String businessPhasesId;
    private String businessPhases;
    private Integer businessState;
    private Date createTime;
    private User user;
    private Customer customer;

    public Double getEstimatedSuccess() {
        estimatedSuccess=estimatedSuccess*100;
        return estimatedSuccess;
    }


}
