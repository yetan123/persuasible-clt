package com.simplify.service.impl;

import com.simplify.mapper.UserMapper;
import com.simplify.model.dto.UserAndDeptDTO;
import com.simplify.model.dto.UserAuthorizeDTO;
import com.simplify.model.dto.UserVO;
import com.simplify.model.entity.User;
import com.simplify.service.UserService;
import com.simplify.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

/**
 * 用户业务实现类,是用户业务接口的具体实现
 * @author yuntian
 * @date 2019-11-30
 */
@Service
public class UserServiceImpl implements UserService

{
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
    public List<UserVO> listUserByNotId(String id) {
        return userMapper.listUserByNotId(id);
    }

    @Override
    public UserAuthorizeDTO findUserAuthorizeById(Long id) {
        return userMapper.findUserAndRoleByUserId(id);
    }

    @Override
    public List<UserAndDeptDTO> findUserAndDeptDeptId() {
        return userMapper.findUserAndDeptDeptId();
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public int updateById(User u) {
        return userMapper.updateById(u);
    }

    @Override
    public List<User> listUser(Map params) {
        return userMapper.listUser(params);
    }

    @Override
    public PageBean<UserAndDeptDTO> listUserAndDept(String deptName, String userSearch, Integer currentPage) {
        PageBean<UserAndDeptDTO> pageBean = new PageBean<UserAndDeptDTO>();
        pageBean.setPageNum(currentPage);
        int pageSize=4;
        pageBean.setPageSize(pageSize);
        int totalCount = userMapper.selectCounts(deptName,userSearch);
        pageBean.setTotalCount(totalCount);
        double tc = totalCount;
        Double num = Math.ceil(tc / pageSize);//向上取整
        pageBean.setTotalPage(num.intValue());
        int start=(currentPage-1)*pageSize;
        int size =pageBean.getPageSize();
        //封装每页显示的数据
        List<UserAndDeptDTO> lists = userMapper.listUserAndDept(deptName,userSearch,start,size);
        pageBean.setLists(lists);
        System.out.println(lists+"----------");
        return pageBean;
    }





  /*  @Override
    public List<UserAndDeptDTO> listUserAndDept(String deptName, String userSearch) {
        return userMapper.listUserAndDept(deptName,userSearch);
    }*/



}
