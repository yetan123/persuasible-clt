package com.simplify.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import java.sql.Date;
@Table(name="tb_contract_conver")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CntractConver {
    private Long id;
    private Long contractId;
    private Long converUserId;
    private Long receiveUserId;
    private Date converTime;
}
