package com.simplify.model.vo;

import com.simplify.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductVO {
    private String id;
    private String productName;
    private String productClassify;
    private Float productPrice;
    private String productModel;
    private Float productCost;
    private Integer productRepertory;
    private Integer productStatus;
    private Date establishDate;
    private Long userId;
    private User user;
}
