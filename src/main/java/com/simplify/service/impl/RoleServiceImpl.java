package com.simplify.service.impl;

import com.simplify.mapper.RoleMapper;
import com.simplify.model.entity.Role;
import com.simplify.model.vo.RoleAuthorizeVO;
import com.simplify.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 角色业务接口实现类
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<Role> listRole() {
        return roleMapper.selectAll();
    }

    @Cacheable(value = "roleAuthorize")
    @Override
    public List<RoleAuthorizeVO> listRoleAuthorize() {
        return roleMapper.listRoleAuthorize();
    }

    @CacheEvict(value = {"roleAuthorize"},allEntries = true)
    @Override
    public Integer updateRole(Role role) {
        int i = roleMapper.updateByPrimaryKeySelective(role);
        return i;
    }
}
