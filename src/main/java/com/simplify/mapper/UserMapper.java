package com.simplify.mapper;

import com.simplify.model.dto.UserAndDeptDTO;
import com.simplify.model.dto.UserAuthorizeDTO;
import com.simplify.model.entity.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 用户映射层
 * @author yuntian
 * @date 2019-11-30
 */
@Repository
public interface UserMapper extends Mapper<User> {
    UserAuthorizeDTO findUserAndRoleByUserId(Long id);

    List<UserAndDeptDTO> findUserAndDeptDeptId();
}
