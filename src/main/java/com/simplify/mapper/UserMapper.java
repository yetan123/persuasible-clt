package com.simplify.mapper;

import com.simplify.model.dto.UserAndDeptDTO;
import com.simplify.model.dto.UserAndDeptVO;
import com.simplify.model.dto.UserAuthorizeDTO;
import com.simplify.model.entity.User;
import org.apache.ibatis.annotations.Param;
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
    //查询
    List<UserAndDeptDTO> findUserAndDeptDeptId();
    //修改
    int updateByUserId(UserAndDeptVO u);
    //删除
    int deleteByUserId(UserAndDeptVO userAndDeptVO);
    //新增
    int insertUser(User user);
    //查询
    List<User> listUser(Map params);
    //分页 模糊查询
    List<UserAndDeptVO> listUserAndDept(@Param("deptname") String deptname, @Param("username") String username,@Param("enabled") String enabled, @Param("start") int start, @Param("size") int size);
    //查询总记录
    int selectCounts(@Param("deptname") String deptname,@Param("username") String username,@Param("enabled") String enabled);
}
