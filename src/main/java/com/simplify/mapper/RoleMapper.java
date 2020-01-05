package com.simplify.mapper;

import com.simplify.model.entity.Role;
import com.simplify.model.vo.RoleAuthorizeVO;
import com.simplify.model.vo.RoleMiddleVO;
import org.apache.ibatis.annotations.Param;
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
    //分页 模糊查询
    List<RoleAuthorizeVO> listRoleAuthorize(@Param("roleName") String roleName,@Param("oldDate") String oldDate,@Param("newDate") String newDate,int start, @Param("size") int size);

    //查询总记录
    int selectCounts(@Param("roleName") String roleName,@Param("oldDate") String oldDate,@Param("newDate") String newDate);

}
