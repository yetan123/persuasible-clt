package com.simplify.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 封装QQ登录后相关信息
 * @author yuntian
 * @date 2019-12-29
 */
@Table(name = "tb_qq")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QQ {
    @Id
    private String openId;

    private String nickname;

    private String figureUrl;

    private String gender;

    private Long userId;

    private String password;
}
