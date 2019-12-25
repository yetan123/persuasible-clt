package com.simplify.persuasiblecrm;

import com.simplify.model.dto.UserAuthorizeDTO;
import com.simplify.mapper.UserMapper;
import com.simplify.model.entity.Business;
import com.simplify.model.entity.User;
import com.simplify.service.*;
import com.simplify.service.BusinessService;
import com.simplify.service.CustomerRecordService;
import com.simplify.service.CustomerTasksService;
import com.simplify.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class PersuasibleCrmApplicationTests {

    @Autowired
    private CustomerService customerService;
    private CustomerRecordService customerRecordService;


    private CustomerTasksService customerTasksService;

    @Test
    void contextLoads() {
<<<<<<< HEAD
        Long id = 407157154483535872L;

        System.out.println(customerService.selectbyId(id));
=======

>>>>>>> e0570a43eb6b43f5bed75b0d25138fe46778e60a
    }


}
