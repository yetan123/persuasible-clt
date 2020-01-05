package com.simplify.mapper;
import com.simplify.model.dto.*;
import com.simplify.model.entity.User;
import com.simplify.model.vo.PrincipalBusinessTaskVO;
import com.simplify.model.vo.RoleMiddleVO;
import com.simplify.model.vo.UserRoleVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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
    //修改用户基本信息
    int updateByUserId(UserAndDeptVO u);
    //删除用户基本信息
    int deleteByUserId(UserAndDeptVO userAndDeptVO);
    //新增用户基本信息
    int insertUser(UserAndDeptVO user);
    //修改状态
    int updateByState(UserAndDeptVO userAndDeptVO);
    //分页 模糊查询
    List<UserAndDeptVO> listUserAndDept(@Param("deptname") String deptname, @Param("username") String username,@Param("enabled") String enabled,@Param("pid") String pid, @Param("start") int start, @Param("size") int size);
    //查询总记录
    int selectCounts(@Param("deptname") String deptname,@Param("username") String username,@Param("pid") String pid,@Param("enabled") String enabled);
    //根据验证码修改密码
    int updateCodeById(UserAndDeptVO userAndDeptVO);

    int updateUserRole(UserRoleDTO userRoleDTO);

    int deleteUserRole(UserAndDeptVO userAndDeptVO);
    //根据账号名称查找避免重复
    UserAndDeptVO selectByName(@Param("account") String account);
    //个人信息
    UserAndDeptDTO getUserInfo(UserAndDeptDTO userAndDeptVO);
    //修改用户名称和手机号
    int updateUserInfo(UserAndDeptDTO userAndDeptVO);
    //给予默认权限
    int insertRole(RoleMiddleVO userAndRoleVO);
    /**
     * 权限
     * @date 2019/12/25
     * @author lanmu
     * @param id
     * @return
     */
    UserRoleVO selectRoleName(String id,String roleId);
    /**
     * 查询一个不包含自己的用户集合
     * @date 2019/12/25
     * @author lanmu
     * @param id
     * @return
     */
    @Select(" select * from tb_user where ( ( id <> #{0} ) ) ")
    List<UserVO>listUserByNotId(String id);

    @Select("select * from tb_user where id = #{0}")
    UserVO getUserVOById(Long id);

}
