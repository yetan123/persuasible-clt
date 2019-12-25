package com.simplify.mapper;

import com.simplify.model.dto.UserAndDeptDTO;
import com.simplify.model.dto.UserAuthorizeDTO;
import com.simplify.model.dto.UserVO;
import com.simplify.model.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 用户映射层
 * @author yuntian
 * @date 2019-11-30
 */
@Repository
public interface UserMapper extends Mapper<User> {
    UserAuthorizeDTO findUserAndRoleByUserId(Long id);

    List<UserAndDeptDTO> findUserAndDeptDeptId();

    int updateById(User u);

    int insertUser(User user);

    List<User> listUser(Map params);
    //分页 模糊查询
    List<UserAndDeptDTO> listUserAndDept(@Param("deptName") String deptName, @Param("userSearch") String userSearch,@Param("start") int start,@Param("size") int size);
    //查询总记录
    int selectCounts(@Param("deptName") String deptName,@Param("userSearch") String userSearch);

    /**
     * 查询一个不包含自己的用户集合
     * @date 2019/12/25
     * @author lanmu
     * @param id
     * @return
     */
    @Select(" select * from tb_user where ( ( id <> #{0} ) ) ")
    List<UserVO>listUserByNotId(String id);
}
