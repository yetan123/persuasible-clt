package com.simplify.service;

import com.simplify.model.dto.UserAndDeptDTO;
import com.simplify.model.dto.UserAuthorizeDTO;
import com.simplify.model.entity.User;

import java.util.List;


/**
 * 用户表业务接口,提供对用户表的抽象方法
 * @author yuntian
 * @date 2019-1130
 */
public interface UserService {

        User findUserByAccount(String account);

        List<User> findAll(); //查询全部

        UserAuthorizeDTO findUserAuthorizeById(Long id);

        List<UserAndDeptDTO> findUserAndDeptDeptId();//用户与部门多表查询

}
