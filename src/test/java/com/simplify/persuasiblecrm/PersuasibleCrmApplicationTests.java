package com.simplify.persuasiblecrm;

<<<<<<< HEAD

=======
>>>>>>> 15ade0ecff057abb6d457a9c4ba96a0833b5abfa
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
<<<<<<< HEAD
=======

>>>>>>> 15ade0ecff057abb6d457a9c4ba96a0833b5abfa
    @Autowired
    private CustomerService customerService;
    private CustomerRecordService customerRecordService;


    private CustomerTasksService customerTasksService;
<<<<<<< HEAD

=======
>>>>>>> 15ade0ecff057abb6d457a9c4ba96a0833b5abfa

    @Test
    void contextLoads() {

        Long id = 407157154483535872L;

        System.out.println(customerService.selectbyId(id));
    }


}
