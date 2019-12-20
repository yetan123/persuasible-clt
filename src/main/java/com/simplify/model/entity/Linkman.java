package com.simplify.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "tb_linkman")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Linkman {
    @Id
    private Long id;
    private Long customerId;
    private String customerName;
    private String genders;
    private Date brithday;
    private String phone;
    private String email;
    private Long likeProductId;
    private String likeCustomer;
    private String customerRemark;
    private Customer customer;


    @Override
    public String toString() {
        return "Linkman{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", genders='" + genders + '\'' +
                ", brithday=" + brithday +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", likeProductId=" + likeProductId +
                ", likeCustomer='" + likeCustomer + '\'' +
                ", customerRemark='" + customerRemark + '\'' +
                ", customer=" + customer +
                '}';
    }
}
