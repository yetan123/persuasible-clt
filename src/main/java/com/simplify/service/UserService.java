package com.simplify.service;

import com.simplify.model.dto.UserAuthorizeDTO;
import com.simplify.model.entity.User;


/**
 * 用户表业务接口,提供对用户表的抽象方法
 * @author yuntian
 * @date 2019-1130
 */
public interface UserService {
    User findUserByAccount(String account);
    UserAuthorizeDTO findUserAuthorizeById(Long id);
}
