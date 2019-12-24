package com.simplify.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
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
    private String estimatedDate;
    private Double estimatedSuccess;
    private String customerDecision;
    private String findDate;
    private String businessDescription;
    private Long userId;
    private Long businessSourceId;
    private Long customerId;
    private String buisnessType;
    private String businessPhases;
    private Integer businessState;
    private String createTime;
    private List<Customer> customer;
    private List<User> user;
}
