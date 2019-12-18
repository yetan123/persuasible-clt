package com.simplify.service;

import com.simplify.model.entity.User;

import java.util.List;

/**
 * 用户表业务接口,提供对用户表的抽象方法
 * @author yuntian
 * @date 2019-1130
 */
public interface UserService {
        User findUserByUserNameAndPassword(User user);
        User findUserByUserName(String userName);
        User findUserByAccount(String account);
}
