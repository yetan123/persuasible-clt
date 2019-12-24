package com.simplify.persuasiblecrm;

import com.simplify.model.dto.UserAuthorizeDTO;
import com.simplify.mapper.UserMapper;
import com.simplify.model.entity.Business;
import com.simplify.model.entity.User;
import com.simplify.service.BusinessService;
<<<<<<< HEAD
=======

>>>>>>> 8d3f9ae4d6dc5e31d5bd009239adad0ecfe978d0
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

<<<<<<< HEAD
    private CustomerTasksService customerTasksService;
=======

    private CustomerTasksService customerTasksService;
    @Test
>>>>>>> 8d3f9ae4d6dc5e31d5bd009239adad0ecfe978d0
    void contextLoads() {
        System.out.println(customerTasksService.selectAllTasksCustomerTasks());
    }


}
