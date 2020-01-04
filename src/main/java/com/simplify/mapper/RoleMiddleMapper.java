package com.simplify.mapper;

import com.simplify.model.vo.RoleMiddleVO;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RoleMiddleMapper {

    int insertRole(RoleMiddleVO userAndRoleVO);
    //查询方法
    List<RoleMiddleVO> listRole();
}
