package com.simplify.persuasiblecrm;

import com.simplify.model.dto.UserAuthorizeDTO;
import com.simplify.mapper.UserMapper;
import com.simplify.model.entity.Business;
import com.simplify.model.entity.User;
import com.simplify.service.BusinessService;
<<<<<<< HEAD
=======

>>>>>>> aeb16379ccdfdb6410304cea0ed6aad742c0f14a
import com.simplify.service.CustomerRecordService;
import com.simplify.service.CustomerTasksService;
import com.simplify.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class PersuasibleCrmApplicationTests {

    @Autowired
    private CustomerRecordService customerRecordService;

    private CustomerTasksService customerTasksService;

    @Test
    void contextLoads() {
        System.out.println(customerTasksService.selectAllTasksCustomerTasks());
    }


}
