package com.simplify.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 用户和部门
 * @author yuntian
 * @date 2019-12-18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAndDeptDTO {
    private Long id;

    private String account;

    private String username;

    private String password;

    private String genders;

    private String phone;

    private String job;

    private Long deptId;

    private Integer userState;

    private List<String> depts;

}
