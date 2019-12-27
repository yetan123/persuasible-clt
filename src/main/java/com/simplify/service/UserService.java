package com.simplify.service;
import com.simplify.model.dto.UserAndDeptDTO;
import com.simplify.model.dto.UserAndDeptVO;
import com.simplify.model.dto.UserAuthorizeDTO;
import com.simplify.model.dto.UserVO;
import com.simplify.model.entity.User;
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

        List<UserAndDeptDTO> findUserAndDeptDeptId();//用户与部门多表查询

        int insertUser(User user);

        int updateByUserId(UserAndDeptVO u);

        List<User> listUser(Map params);
        //分页 模糊查询
        PageBean<UserAndDeptVO> listUserAndDept(String deptName, String userName, String enabled, Integer currentPage);

        int deleteByUserId(UserAndDeptVO userAndDeptVO);
}
