package com.simplify.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * githubAndUser信息封装
 * @author yuntian
 * @date 2019-12-30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GithubDTO {
    private Long id;

    private String name;

    private String login;

    private String email;

    private String avatarUrl;

    private String account;

    private String password;
}
