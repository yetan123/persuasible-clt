package com.simplify.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

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

    private Integer pid;

    private Integer userState;

    private List<String> depts;

    /*暂时存放*/
    private String id1;

    private String id2;

    private String id3;

    private String text1;

    private String text2;

    private String text3;
}
