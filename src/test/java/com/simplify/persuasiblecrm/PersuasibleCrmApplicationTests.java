package com.simplify.persuasiblecrm;

import com.simplify.model.dto.UserAuthorizeDTO;
<<<<<<< HEAD

=======
import com.simplify.mapper.UserMapper;
import com.simplify.model.entity.User;
>>>>>>> 2801f2f3c835a6d70e41db2876e5185f9f78bbf8
import com.simplify.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class PersuasibleCrmApplicationTests {
    @Autowired
    UserService userService;
    private UserService userServiceImpl;
    @Test
    void contextLoads() {
        UserAuthorizeDTO userAuthorizeById = userServiceImpl.findUserAuthorizeById(156478515478214567L);
        System.out.println(userAuthorizeById);
    }

}
