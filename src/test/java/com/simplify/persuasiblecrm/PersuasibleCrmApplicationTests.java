package com.simplify.persuasiblecrm;

import com.simplify.mapper.UserMapper;
import com.simplify.model.entity.User;
import com.simplify.service.UserService;
import com.simplify.utils.SnowFlake;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootTest
class PersuasibleCrmApplicationTests {
    @Autowired
    UserService userService;
    @Test
    void contextLoads() {
        SnowFlake snowFlake = new SnowFlake(0,0);
        long id = snowFlake.nextId();
    }

}
