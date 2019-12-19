package com.simplify.persuasiblecrm;

import com.simplify.model.dto.UserAuthorizeDTO;

import com.simplify.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class PersuasibleCrmApplicationTests {
    @Autowired
    private UserService userServiceImpl;
    @Test
    void contextLoads() {
        UserAuthorizeDTO userAuthorizeById = userServiceImpl.findUserAuthorizeById(156478515478214567L);
        System.out.println(userAuthorizeById);
    }

}
