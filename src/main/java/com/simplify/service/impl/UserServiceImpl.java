package com.simplify.service.impl;
import com.simplify.mapper.UserMapper;
import com.simplify.model.dto.*;
import com.simplify.model.entity.User;
import com.simplify.model.vo.UserRoleVO;
import com.simplify.service.UserService;
import com.simplify.utils.PageBean;
import com.simplify.utils.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
import java.util.Map;

/**
 * 用户业务实现类,是用户业务接口的具体实现
 * @author yuntian
 * @date 2019-11-30
 */
@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findUserByAccount(String account) {
        Example  example =new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("account",account);
        return userMapper.selectOneByExample(example);
    }

    @Override
    public List<UserVO> listUserByNotId(String id) {
        return userMapper.listUserByNotId(id);
    }

    @Override
    public UserAuthorizeDTO findUserAuthorizeById(Long id) {
        return userMapper.findUserAndRoleByUserId(id);
    }

    @CacheEvict(cacheNames = {"businessTaskPrincipal"})
    @Override
    public int insertUser(UserAndDeptVO user) {
        return userMapper.insertUser(user);
    }

    @CacheEvict(cacheNames = {"businessTaskPrincipal"})
    @Override
    public int updateByUserId(UserAndDeptVO u) {
        return userMapper.updateByUserId(u);
    }

    @Override
    public int updateByState(UserAndDeptVO userAndDeptVO) {
        return userMapper.updateByState(userAndDeptVO);
    }
    @Override
    public PageBean<UserAndDeptVO> listUserAndDept(String deptname, String username, String enabled,String pid, Integer currentPage) {
        PageBean<UserAndDeptVO> pageBean = new PageBean<UserAndDeptVO>();
        //封装当前页数
        pageBean.setPageNum(currentPage);
        //每页显示的数据
        int pageSize=5;
        pageBean.setPageSize(pageSize);
        //封装总记录数
        int totalCount = userMapper.selectCounts(deptname,username,enabled,pid);
        pageBean.setTotalCount(totalCount);
        //封装总页数
        double tc = totalCount;
        Double num = Math.ceil(tc / pageSize);//向上取整
        pageBean.setTotalPage(num.intValue());
        int start=(currentPage-1)*pageSize;
        int size = pageBean.getPageSize()*pageBean.getPageNum();
        //封装每页显示的数据
        List<UserAndDeptVO> lists = userMapper.listUserAndDept(deptname,username,enabled,pid,start,size);
        pageBean.setLists(lists);
        /*  System.out.println(lists+"----------结束");*/
        return pageBean;
    }

    @Override
    public int updateCodeById(UserAndDeptVO userAndDeptVO) {
        return userMapper.updateCodeById(userAndDeptVO);
    }
    @Override
    public User findUserById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public UserAndDeptVO selectByName(String account) {
        return userMapper.selectByName(account);
    }

    @Override
    public UserRoleVO selectRoleName(String id, String roleId) {
        return userMapper.selectRoleName(id,roleId);
    }

    @PreAuthorize("hasAuthority('修改用户角色:PUT')")
    @Override
    public int updateUserRole(UserAndDeptVO userAndDeptVO) {
        System.out.println(userAndDeptVO);
        SnowFlake snowFlake = new SnowFlake(0,0);
        List<String> roleIds = userAndDeptVO.getRoleIds();
        roleIds.forEach(roleId->userMapper.updateUserRole(new UserRoleDTO(snowFlake.nextId(),Long.parseLong(userAndDeptVO.getId()),Long.parseLong(roleId))));
        int i = userMapper.deleteUserRole(userAndDeptVO);
        return i;
    }

    @CacheEvict(cacheNames = {"businessTaskPrincipal"})
    @Override
    public int deleteByUserId(UserAndDeptVO userAndDeptVO) {
        return userMapper.deleteByUserId(userAndDeptVO);
    }



}