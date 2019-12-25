package com.simplify.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
/*
合同类型类
*/
@Table(name="tb_contract_type")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContractType {
    private Long id;
    private String contractType;
    private String describe;
}
