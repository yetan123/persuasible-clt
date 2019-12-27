package com.simplify.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAndDeptVO {
    private String id;

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
