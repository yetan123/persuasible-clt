package com.simplify.persuasiblecrm;

import com.simplify.mapper.DeptMapper;
import com.simplify.mapper.RoleMapper;
import com.simplify.mapper.RoleMiddleMapper;
import com.simplify.mapper.UserMapper;
import com.simplify.model.dto.UserAndDeptDTO;
import com.simplify.model.dto.UserAndDeptVO;
import com.simplify.service.DeptService;
import com.simplify.service.MenuService;
import com.simplify.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class UserApplication {
    @Autowired
    private MenuService menuServiceImpl;
    @Autowired
    private DeptService deptService;
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMiddleMapper roleMiddleMapper;
    @Test
    void contextLoads() {
        UserAndDeptDTO u =new UserAndDeptDTO();
        u.setId("409138416777691136");
        System.out.println(userMapper.getUserInfo(u));
    }

}
