package com.simplify.persuasiblecrm;

import com.simplify.model.dto.UserAuthorizeDTO;

import com.simplify.mapper.UserMapper;
import com.simplify.model.entity.Business;
import com.simplify.model.entity.User;
import com.simplify.service.BusinessService;
import com.simplify.service.CustomerRecordService;
import com.simplify.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class PersuasibleCrmApplicationTests {

    @Autowired
    private CustomerRecordService customerRecordService;

    @Test
    void contextLoads() {
        System.out.println(customerRecordService.selectAllCustomerRecord());
    }


}
