package com.simplify.persuasiblecrm;
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
    private UserService userService;
    @Autowired
    private DeptService deptService;
    @Test
    void contextLoads() {

    }
}
