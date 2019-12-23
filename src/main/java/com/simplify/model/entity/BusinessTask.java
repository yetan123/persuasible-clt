package com.simplify.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 商机跟进任务表实体类
 * @author 杨泓
 * @date 2019-12-17
 */

@Table(name="tb_business_task")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessTask {
    @Id
    private Long id;
    private String taskContent;
    private String taskDate;
    private String taskFinishDate;
    private Long businessId;
    private Integer taskState;

}
