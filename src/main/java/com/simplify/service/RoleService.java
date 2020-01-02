package com.simplify.service;

import com.simplify.model.entity.Role;
import com.simplify.model.vo.RoleAuthorizeVO;
import com.simplify.utils.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色业务接口
 * @author yuntian
 * @date 2019-12-21
 */
public interface RoleService {
    List<Role> listRole();
    //分页 模糊查询
    PageBean<RoleAuthorizeVO> listRoleAuthorize(String roleName,String oldDate,String newDate,Integer currentPage);

    Integer updateRole(Role role);

    Integer removeRoleById(Long id);

    RoleAuthorizeVO insertRole(Role role);
}
