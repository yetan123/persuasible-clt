package com.simplify.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import java.sql.Date;
/*
  合同跟进类
 */

@Table(name="tb_contract_task")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContractTask {
    private Long id;
    private Long contractId;
    private String scheduledTask;
    private Date startTime;
    private Date endTime;
    private String state;
    private Date completionTime;
    private String participant;
}
