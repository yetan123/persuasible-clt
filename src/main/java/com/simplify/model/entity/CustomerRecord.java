package com.simplify.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

/**
 * @author water
 * @date 2019-12-18
 */
@Table(name="tb_customer_record")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRecord {
    @Id
    private Long id;

    private String recordContent;

    private String recordType;

    private String recordProgress;

    private Date recordTime;

    private Date recordNextTime;

    private Long customerId;

    private Long linkmanId;

    private Linkman linkman;

    private Customer customer;
}
