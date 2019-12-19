package com.simplify.persuasiblecrm;

import com.simplify.model.dto.RouteDTO;
import com.simplify.service.MenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserApplication {
    @Autowired
    private MenuService menuServiceImpl;
    @Test
    void contextLoads() {
        List<RouteDTO> routeDTOS = menuServiceImpl.listMenu();
        System.out.println(routeDTOS);

    }
}
