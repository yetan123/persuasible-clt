package com.simplify.persuasiblecrm;

import com.simplify.model.dto.UserAuthorizeDTO;

import com.simplify.mapper.UserMapper;
import com.simplify.model.entity.Business;
import com.simplify.model.entity.User;
<<<<<<< HEAD
import com.simplify.service.BusinessService;
=======
import com.simplify.service.CustomerRecordService;
>>>>>>> c0271470b2cb1c7dce6085e7bac2e76abb827c72
import com.simplify.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class PersuasibleCrmApplicationTests {
    @Autowired
<<<<<<< HEAD
    BusinessService businessService;

=======
    private CustomerRecordService customerRecordService;
>>>>>>> c0271470b2cb1c7dce6085e7bac2e76abb827c72
    @Test
    void contextLoads() {
        System.out.println(customerRecordService.selectAllCustomerRecord());
    }


}
