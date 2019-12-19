package com.simplify.persuasiblecrm;

import com.simplify.utils.SnowFlake;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersuasibleCrmApplicationTests {
    @Test
    void contextLoads() {
        SnowFlake snowFlake = new SnowFlake(0,0);
        long id = snowFlake.nextId();
    }

}
