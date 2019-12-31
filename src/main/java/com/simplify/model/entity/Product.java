package com.simplify.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "TB_PRODUCT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    private Long id;
    private String productName;
    private String productClassify;
    private Float productPrice;
    private String productModel;
    private Float productCost;
    private Integer productRepertory;
    private Integer productStatus;
    private Date establishDate;
    private Long userId;
}
