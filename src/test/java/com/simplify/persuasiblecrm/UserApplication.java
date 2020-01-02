package com.simplify.persuasiblecrm;

import com.simplify.mapper.DeptMapper;
import com.simplify.model.dto.DeptVO;
import com.simplify.model.dto.RouteDTO;
import com.simplify.service.DeptService;
import com.simplify.service.MenuService;
import com.simplify.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Random;


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
    @Test
    void contextLoads() {
       /* String code = String.valueOf(new Random().nextInt(9999));*/
    }

}
