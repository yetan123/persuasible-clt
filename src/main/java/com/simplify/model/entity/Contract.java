package com.simplify.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Table(name="tb_contract")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contract {
    @Id
    private Long id;
    private String contractCode;
    private String contractName;
    private Date contractDate;
    private Date startTime;
    private Date endTime;
    private Double moneyUnit;
    private Double TotalMoney;
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

}
