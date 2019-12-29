package com.simplify.persuasiblecrm;

import com.simplify.model.dto.RouteDTO;
import com.simplify.service.MenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@SpringBootTest
public class UserApplication {
    @Test
    void contextLoads() {
        System.out.println(new BCryptPasswordEncoder().encode("962464"));
    }

}
