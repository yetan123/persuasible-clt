package com.simplify.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 封装QQ登录后相关信息
 * @author yuntian
 * @date 2019-12-29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QQ {
    private Long openId;

    private String nickname;

    private String figureurl;

    private String gender;

    private User user;
}
