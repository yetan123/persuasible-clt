package com.simplify.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContractVO {
    private String id;
    private String contractCode;
    private String contractName;
    private Date contractDate;
    private Date startTime;
    private Date endTime;
    private Double moneyUnit;
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
    private UserVO userVO;
    private CustomerVO customerVO;
}
