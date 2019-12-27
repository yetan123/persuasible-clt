package com.simplify.service.impl;
import com.simplify.mapper.UserMapper;
import com.simplify.model.dto.UserAndDeptDTO;
import com.simplify.model.dto.UserAndDeptVO;
import com.simplify.model.dto.UserAuthorizeDTO;
import com.simplify.model.entity.User;
import com.simplify.service.UserService;
import com.simplify.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<User> listUserByNotId(Long id) {
        Example  example =new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andNotEqualTo("id",id);
        return userMapper.selectByExample(example);
    }

    @Override
    public UserAuthorizeDTO findUserAuthorizeById(Long id) {
        return userMapper.findUserAndRoleByUserId(id);
    }

    @Override
    public List<UserAndDeptDTO> findUserAndDeptDeptId() {
        return userMapper.findUserAndDeptDeptId();
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public int updateByUserId(UserAndDeptVO u) {
        return userMapper.updateByUserId(u);
    }

    @Override
    public List<User> listUser(Map params) {
        return userMapper.listUser(params);
    }

    @Override
    public PageBean<UserAndDeptVO> listUserAndDept(String deptname, String username, String enabled, Integer currentPage) {
        PageBean<UserAndDeptVO> pageBean = new PageBean<UserAndDeptVO>();
        //封装当前页数
        pageBean.setPageNum(currentPage);
        //每页显示的数据
        int pageSize=5;
        pageBean.setPageSize(pageSize);
        //封装总记录数
        int totalCount = userMapper.selectCounts(deptname,username,enabled);
        pageBean.setTotalCount(totalCount);
        //封装总页数
        double tc = totalCount;
        Double num = Math.ceil(tc / pageSize);//向上取整
        pageBean.setTotalPage(num.intValue());
        int start=(currentPage-1)*pageSize;
        int size = pageBean.getPageSize()*pageBean.getPageNum();
        //封装每页显示的数据
        List<UserAndDeptVO> lists = userMapper.listUserAndDept(deptname,username,enabled,start,size);
        pageBean.setLists(lists);
      /*  System.out.println(lists+"----------结束");*/
        return pageBean;
    }

    @Override
    public int deleteByUserId(UserAndDeptVO userAndDeptVO) {
        return userMapper.deleteByUserId(userAndDeptVO);
    }



}
