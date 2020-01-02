package com.simplify.service.impl;

import com.simplify.mapper.RoleMapper;
import com.simplify.model.dto.UserAndDeptVO;
import com.simplify.model.entity.Role;
import com.simplify.model.vo.RoleAuthorizeVO;
import com.simplify.model.vo.RoleVO;
import com.simplify.service.RoleService;
import com.simplify.utils.PageBean;
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
    public PageBean<RoleAuthorizeVO> listRoleAuthorize(String roleName,String oldDate,String newDate,Integer currentPage) {
        PageBean<RoleAuthorizeVO> pageBean = new PageBean<RoleAuthorizeVO>();
        //封装当前页数
        pageBean.setPageNum(currentPage);
        //每页显示的数据
        int pageSize=5;
        pageBean.setPageSize(pageSize);
        //封装总记录数
        int totalCount = roleMapper.selectCounts(roleName,oldDate,newDate);
        pageBean .setTotalCount(totalCount);
        //封装总页数
        double tc = totalCount;
        Double num = Math.ceil(tc / pageSize);//向上取整
        pageBean.setTotalPage(num.intValue());
        int start=(currentPage-1)*pageSize;
        int size = pageBean.getPageSize() * pageBean.getPageNum();
        //封装每页显示的数据
        List<RoleAuthorizeVO> lists = roleMapper.listRoleAuthorize(roleName,oldDate,newDate,start,size);
        pageBean.setLists(lists);
        return pageBean;
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

    @Override
    public List<RoleVO> listRoleVO() {
        List<Role> roles = roleMapper.selectAll();
        List<RoleVO> roleList = new ArrayList<>();
        roles.forEach(role->roleList.add(new RoleVO(role.getId().toString(),role.getRoleName())));
        return roleList;
    }

}
