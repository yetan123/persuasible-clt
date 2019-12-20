package com.simplify.service;

import com.simplify.model.dto.UserAuthorizeDTO;
import com.simplify.model.entity.User;

import java.util.List;


/**
 * 用户表业务接口,提供对用户表的抽象方法
 * @author yuntian
 * @date 2019-1130
 */
public interface UserService {
<<<<<<< HEAD
=======

>>>>>>> c0271470b2cb1c7dce6085e7bac2e76abb827c72
        User findUserByAccount(String account);

        List<User> findAll(); //查询全部

        UserAuthorizeDTO findUserAuthorizeById(Long id);

}
