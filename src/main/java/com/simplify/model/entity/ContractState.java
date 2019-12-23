package com.simplify.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
/*
合同状态类
 */
@Table(name="tb_contract_state")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContractState {
    private Long id;
    private String contractState;
    private String describe;
}
