package com.simplify.persuasiblecrm;

import com.simplify.model.dto.DeptVO;
import com.simplify.model.dto.RouteDTO;
import com.simplify.service.DeptService;
import com.simplify.service.MenuService;
import com.simplify.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@SpringBootTest
public class UserApplication {
<<<<<<< HEAD
    @Autowired
    private MenuService menuServiceImpl;
    @Autowired
    private DeptService deptService;
    @Autowired
    private UserService userService;
    @Test
    void contextLoads() {
        System.out.println(userService.listUserAndDept(null,null,null,1));;

=======
    @Test
    void contextLoads() {
        System.out.println(new BCryptPasswordEncoder().encode("962464"));
>>>>>>> f5aec6cabafaaefe18c832e03c677ca468158a21
    }

}
