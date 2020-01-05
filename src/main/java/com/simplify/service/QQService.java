package com.simplify.service;

import com.simplify.model.entity.QQ;

/**
 * qq业务接口
 * @author yuntian
 * @date 2020-1-4
 */
public interface QQService {
    QQ selectQQByOpenId(String openId);

    QQ selectQQByUserId(Long userId);

    Integer BindingUser(QQ qq);
}
