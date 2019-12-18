package com.simplify.mapper;

import com.simplify.model.dto.UserAuthorizeDTO;
import com.simplify.model.entity.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * 用户映射层
 * @author yuntian
 * @date 2019-11-30
 */
@Repository
public interface UserMapper extends Mapper<User> {
    UserAuthorizeDTO findUserAndRoleByUserId(String id);
}
