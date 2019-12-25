package com.simplify.model.dto;

import com.simplify.model.entity.CustomerConver;
import com.simplify.model.entity.CustomerTasks;
import com.simplify.model.entity.Linkman;
import com.simplify.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * 封裝发送给前端的客户数据
 * @author lanmu
 * @date 2019/12/25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerVO {
    private String id;
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
    private Linkman linkman;
    private List<Linkman> linkmanList;
    private User user;
    private CustomerConver customerConver;
}
