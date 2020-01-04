package com.simplify.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * qq绑定用户数据传输对象
 * @author yuntian
 * @date 2020-1-4
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QQAndUserDTO {
    private String openId;

    private String nickName;

    private String figureUrl;

    private String gender;

    private String account;

    private String password;
}
