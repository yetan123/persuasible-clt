package com.simplify.service.impl;

import com.simplify.mapper.RoleMapper;
import com.simplify.model.entity.Role;
import com.simplify.model.vo.RoleAuthorizeVO;
import com.simplify.service.RoleService;
import com.simplify.utils.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
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

    @CacheEvict(value = {"roleAuthorize"},allEntries = true)
    @Override
    public Integer removeRoleById(Long id) {
        return roleMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value = {"roleAuthorize"},allEntries = true)
    @Override
    public RoleAuthorizeVO insertRole(Role role) {
        SnowFlake snowFlake = new SnowFlake(0,0);
        long id = snowFlake.nextId();
        role.setId(id);
        roleMapper.insertSelective(role);
        RoleAuthorizeVO roleAuthorizeVO = new RoleAuthorizeVO();
        roleAuthorizeVO.setId(String.valueOf(id));
        roleAuthorizeVO.setRoleName(role.getRoleName());
        roleAuthorizeVO.setRoleDescribe(role.getRoleDescribe());
        roleAuthorizeVO.setSources(new ArrayList<>());
        roleAuthorizeVO.setMenus(new ArrayList<>());
        roleAuthorizeVO.setCreateTime(new Date(new java.util.Date().getTime()));
        return roleAuthorizeVO;
    }
}
