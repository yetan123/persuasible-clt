package com.simplify.service.impl;

import com.simplify.mapper.RoleMiddleMapper;
import com.simplify.model.vo.RoleMiddleVO;
import com.simplify.service.RoleMiddleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("roleMiddleService")
public class RoleMiddleServiceImpl implements RoleMiddleService {
    @Autowired
    private RoleMiddleMapper roleMiddleMapper;
    @Override
    public int insertRole(RoleMiddleVO userAndRoleVO) {
        return roleMiddleMapper.insertRole(userAndRoleVO);
    }

    @Override
    public List<RoleMiddleVO> listRole() {
        return roleMiddleMapper.listRole();
    }
}
