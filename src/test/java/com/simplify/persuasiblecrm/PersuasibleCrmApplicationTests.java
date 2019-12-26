package com.simplify.persuasiblecrm;

<<<<<<< HEAD

=======
<<<<<<< HEAD

=======
>>>>>>> 15ade0ecff057abb6d457a9c4ba96a0833b5abfa
>>>>>>> 1fd99a8d51a7bf1d721da8a3be96aef04100591d
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
<<<<<<< HEAD
=======

>>>>>>> 15ade0ecff057abb6d457a9c4ba96a0833b5abfa
>>>>>>> 1fd99a8d51a7bf1d721da8a3be96aef04100591d
    @Autowired
    private CustomerService customerService;
    private CustomerRecordService customerRecordService;


    private CustomerTasksService customerTasksService;
<<<<<<< HEAD


    @Test
    void contextLoads() {
        Long id = 407157154483535872L;

        System.out.println(customerService.selectbyId(id));

=======
<<<<<<< HEAD

=======
>>>>>>> 15ade0ecff057abb6d457a9c4ba96a0833b5abfa

    @Test
    void contextLoads() {

        Long id = 407157154483535872L;

        System.out.println(customerService.selectbyId(id));
>>>>>>> 1fd99a8d51a7bf1d721da8a3be96aef04100591d
    }


}
