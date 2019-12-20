package com.simplify.service.impl;

import com.simplify.mapper.UserMapper;
import com.simplify.model.dto.UserAuthorizeDTO;
import com.simplify.model.entity.User;
import com.simplify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 用户业务实现类,是用户业务接口的具体实现
 * @author yuntian
 * @date 2019-11-30
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findUserByAccount(String account) {
        Example  example =new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("account",account);
        return userMapper.selectOneByExample(example);
    }

    @Override
    public List<User> findAll() {
        return userMapper.selectAll();
    }

    @Override
    public List<User> listUserByNotId(Long id) {
        Example  example =new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andNotEqualTo("id",id);
        return userMapper.selectByExample(example);
    }

    @Override
    public UserAuthorizeDTO findUserAuthorizeById(Long id) {
        return userMapper.findUserAndRoleByUserId(id);
    }
}
