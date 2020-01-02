package com.simplify.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

/*
  合同类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contract {

    private Long id;
    private String contractCode;
    private String contractName;
    private Date contractDate;
    private Date startTime;
    private Date endTime;
    private String moneyUnit;
    private Double totalMoney;
    private String contractContents;
    private String remark;
    private Long commercialOpportunityId;
    private Long costomerId;
    private Long linkmanId;
    private String contractType;
    private String paymentMethod;
    private String contractState;
    private String contractParticipant;
    private Long secondPartyId;
    private Long firstPartyId;
    private Long creatorId;
    private Long principalId;
    private Date followTime;
    private User user;
    private Customer customer;
}
