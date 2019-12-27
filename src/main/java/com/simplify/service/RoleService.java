package com.simplify.service;

import com.simplify.model.entity.Role;
import com.simplify.model.vo.RoleAuthorizeVO;

import java.util.List;

/**
 * 角色业务接口
 * @author yuntian
 * @date 2019-12-21
 */
public interface RoleService {
    List<Role> listRole();

    List<RoleAuthorizeVO> listRoleAuthorize();

    Integer updateRole(Role role);

    Integer removeRoleById(Long id);

    RoleAuthorizeVO insertRole(Role role);
}
