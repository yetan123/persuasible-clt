package com.simplify.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * github登录信息
 * @author yuntian
 * @date 2019-12-30
 */
@Table(name = "tb_github")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GitHub {
    @Id
    private Long id;

    private String name;

    private Long login;

    private String email;

    private String avatarUrl;

    private String password;

    private Long userId;

}
