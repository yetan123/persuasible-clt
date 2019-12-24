package com.simplify.persuasiblecrm;

import com.simplify.model.dto.RouteDTO;
import com.simplify.model.entity.User;
import com.simplify.service.MenuService;
import com.simplify.service.UserService;
import com.simplify.utils.SnowFlake;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserApplication {
    @Autowired
    private MenuService menuServiceImpl;
    @Autowired
    private UserService userService;
    @Test
    void contextLoads() {

    }
}
