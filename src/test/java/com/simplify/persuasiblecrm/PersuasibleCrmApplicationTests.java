package com.simplify.persuasiblecrm;

import com.simplify.mapper.CustomerMapper;
import com.simplify.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class PersuasibleCrmApplicationTests {

    @Resource
    CustomerService customerService;

    @Test
    void contextLoads() {
        System.out.println( customerService.listCustomer());
    }

}
