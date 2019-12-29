package com.simplify.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author 覃文强
 * @date 2019-12-17
 */
@Table(name="tb_department")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept {
    @Id
    private Long id;

    private String deptName;

    private Integer enterpriseId;

    private String describe;
}
