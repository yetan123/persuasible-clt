package com.simplify.mapper;

import com.simplify.model.entity.Role;
import com.simplify.model.vo.RoleAuthorizeVO;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 角色数据库访问层
 * @author yuntian
 * @date 2019-12-21
 */
@Repository
public interface RoleMapper extends Mapper<Role> {
    List<RoleAuthorizeVO> listRoleAuthorize();
}
