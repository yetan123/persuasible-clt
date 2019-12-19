package com.simplify.persuasiblecrm;

import com.simplify.service.CustomerTasksService;
import com.simplify.service.LinkmanService;
import com.simplify.utils.SnowFlake;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class MethodsTest {
    @Resource
    CustomerTasksService customerTasksService;

    @Test
    void contextLoads() {
        System.out.println(customerTasksService.getCustomerTasksByCustomerId(new Long(1)));
    }

}
