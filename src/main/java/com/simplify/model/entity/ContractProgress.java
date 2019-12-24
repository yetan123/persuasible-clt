package com.simplify.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
/*
  进度类
 */

@Table(name="tb_contract_progress")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContractProgress {
    private Long id;
    private String progressName;
}
