package com.simplify.persuasiblecrm;

<<<<<<< HEAD
import com.simplify.model.dto.UserAuthorizeDTO;
=======
import com.simplify.mapper.UserMapper;
import com.simplify.model.entity.User;
>>>>>>> bf949b9afe71607396a2b23fcb99c2faefd4de33
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
    private UserService userServiceImpl;
    @Test
    void contextLoads() {
        UserAuthorizeDTO userAuthorizeById = userServiceImpl.findUserAuthorizeById(156478515478214567L);
        System.out.println(userAuthorizeById);
    }

}
