package com.simplify.persuasiblecrm;

import com.simplify.model.dto.UserAuthorizeDTO;

import com.simplify.mapper.UserMapper;
import com.simplify.model.entity.Business;
import com.simplify.model.entity.User;
<<<<<<< HEAD
import com.simplify.service.BusinessService;
=======

>>>>>>> 612c3397731ed63654cce2b98104b95fbbfbf786
import com.simplify.service.CustomerRecordService;
import com.simplify.service.CustomerTasksService;
import com.simplify.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class PersuasibleCrmApplicationTests {

    @Autowired
<<<<<<< HEAD
    private CustomerRecordService customerRecordService;

=======
    private CustomerTasksService customerTasksService;
>>>>>>> 612c3397731ed63654cce2b98104b95fbbfbf786
    @Test
    void contextLoads() {
        System.out.println(customerTasksService.selectAllTasksCustomerTasks());
    }


}
