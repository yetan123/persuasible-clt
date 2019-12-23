package com.simplify.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import java.sql.Date;
/*
  合同跟进记录类
 */
@Table(name="tb_contract_record")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContractRecord {
    private Long id;
    private Long contractId;
    private String recordType;
    private String recordContent;
    private Date followTime;
    private Date nextFollowTime;
    private String recordProgress;
}
