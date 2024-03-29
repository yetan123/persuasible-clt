package com.simplify.model.dto;

import com.simplify.model.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 用户数据传输对象
 * @author yuntian
 * @date 2019-12-18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAuthorizeDTO {
    private Long id;

    private String account;

    private String username;

    private String genders;

    private String phone;

    private String job;

    private Long deptId;

    private Integer userState;

    private List<String> roles;
}
