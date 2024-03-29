package com.simplify.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

/**
 * 商机跟进任务表实体类
 * @author 杨泓
 * @date 2019-12-17
 */

@Table(name="tb_business_record")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessRecord {
    @Id
    private Long id;
    private String recordContent;
    private Date recordTime;
    private Date recordNextTime;
    private String schedule;
    private Long businessId;

}
