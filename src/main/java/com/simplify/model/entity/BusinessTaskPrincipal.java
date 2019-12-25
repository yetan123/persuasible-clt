package com.simplify.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 商机任务负责人表实体类
 * @author 杨泓
 * @date 2019-12-25
 */
@Table(name="tb_business_task_principal")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessTaskPrincipal {

    @Id
    private Long id;
    private Long taskId;
    private Long userId;

}
