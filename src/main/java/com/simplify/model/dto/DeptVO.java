package com.simplify.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Id;
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DeptVO {
    @Id
    private String id;

    private String deptName;

    private Integer enterpriseId;

    private String describe;
}
