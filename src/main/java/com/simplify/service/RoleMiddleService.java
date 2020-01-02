package com.simplify.service;

import com.simplify.model.vo.RoleMiddleVO;

import java.util.List;

public interface RoleMiddleService {
    int insertRole(RoleMiddleVO userAndRoleVO);
    //查询方法
    List<RoleMiddleVO> listRole();
}
