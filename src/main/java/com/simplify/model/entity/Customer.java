package com.simplify.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", companyEmail='" + companyEmail + '\'' +
                ", specialPlane='" + specialPlane + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                ", trade='" + trade + '\'' +
                ", companyScale='" + companyScale + '\'' +
                ", customerState='" + customerState + '\'' +
                ", customerCategory='" + customerCategory + '\'' +
                ", customerSourceId=" + customerSourceId +
                ", customerRank='" + customerRank + '\'' +
                ", createTime=" + createTime +
                ", userId=" + userId +
                ", customerTasks=" + customerTasks +
                ", linkmanList=" + linkmanList +
                '}';
    }
}
