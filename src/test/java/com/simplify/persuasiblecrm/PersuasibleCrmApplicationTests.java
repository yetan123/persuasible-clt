package com.simplify.persuasiblecrm;

import com.simplify.model.dto.UserAuthorizeDTO;
<<<<<<< HEAD
=======

>>>>>>> 99a34fb82bb4a80d0ac79076095cd119a3db2f32
import com.simplify.mapper.UserMapper;
import com.simplify.model.entity.Business;
import com.simplify.model.entity.User;
<<<<<<< HEAD
=======
<<<<<<< HEAD
import com.simplify.service.BusinessService;
=======

>>>>>>> 612c3397731ed63654cce2b98104b95fbbfbf786
import com.simplify.service.CustomerRecordService;
import com.simplify.service.CustomerTasksService;
>>>>>>> 99a34fb82bb4a80d0ac79076095cd119a3db2f32
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
<<<<<<< HEAD
    @Test
    void contextLoadss() {
        System.out.println(userService.findUserAndDeptDeptId());
    }
=======


>>>>>>> 99a34fb82bb4a80d0ac79076095cd119a3db2f32
}
