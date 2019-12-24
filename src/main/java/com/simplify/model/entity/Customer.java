package com.simplify.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Table(name = "tb_customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    private Long id;
    private String companyName;
    private String companyEmail;
    private String specialPlane;
    private String companyAddress;
    private String trade;
    private String companyScale;
    private String customerState;
    private String customerCategory;
    private Long customerSourceId;
    private String customerRank;
    private Date createTime;
    private Long userId;
    private CustomerTasks customerTasks;
    private List<Linkman> linkmanList;
    private User user;
    private CustomerConver customerConver;
}
