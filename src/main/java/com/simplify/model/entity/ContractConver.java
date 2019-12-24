package com.simplify.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import java.sql.Date;

/*
  合同转交类
 */
@Table(name="tb_contract_conver")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContractConver {
    private Long id;
    private Long contractId;
    private Long converUserId;
    private Long receiveUserId;
    private Date converTime;
    private User user;
    private Contract contract;
    private Customer customer;
}
