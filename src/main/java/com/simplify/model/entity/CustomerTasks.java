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
@Table(name="tb_customer_tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerTasks {
    @Id
    private Long id;

    private Long customerId;

    private Long linkmanId;

    private String taskName;

    private String taskContent;

    private Date taskStartTime;

    private Date taskEndTime;

    private String taskParticipant;
}
