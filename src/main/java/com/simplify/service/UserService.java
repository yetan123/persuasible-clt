package com.simplify.service;
import com.simplify.model.dto.UserAndDeptDTO;
import com.simplify.model.dto.UserAndDeptVO;
import com.simplify.model.dto.UserAuthorizeDTO;
import com.simplify.model.dto.UserVO;
import com.simplify.model.entity.User;
import com.simplify.model.vo.UserRoleVO;
import com.simplify.utils.PageBean;
import java.util.List;
import java.util.Map;


/**
 * 用户表业务接口,提供对用户表的抽象方法
 * @author yuntian
 * @date 2019-1130
 */
public interface UserService {

        User findUserByAccount(String account);

        List<UserVO> listUserByNotId(String id);

        UserAuthorizeDTO findUserAuthorizeById(Long id);
        //添加用户基本信息
        int insertUser(UserAndDeptVO user);
        //删除用户基本信息
        int deleteByUserId(UserAndDeptVO userAndDeptVO);
        //修改用户基本信息
        int updateByUserId(UserAndDeptVO u);
        //修改状态
        int updateByState(UserAndDeptVO userAndDeptVO);
        //分页 模糊查询

        PageBean<UserAndDeptVO> listUserAndDept(String deptName, String userName, String enabled,String pid, Integer currentPage);
        //根据验证码修改密码
        int updateCodeById(UserAndDeptVO userAndDeptVO);

        User findUserById(Long id);
        //根据账号名称查找避免重复
        UserAndDeptVO selectByName(String account);
        //权限
        UserRoleVO selectRoleName(String id, String roleId);

        int updateUserRole(UserAndDeptVO userAndDeptVO);

        //个人信息
        UserAndDeptDTO getUserInfo(UserAndDeptDTO userAndDeptVO);
        //修改用户名称和手机号
        int updateUserInfo(UserAndDeptDTO userAndDeptVO);

}
