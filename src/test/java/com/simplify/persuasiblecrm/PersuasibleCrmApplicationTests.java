package com.simplify.persuasiblecrm;


import com.simplify.model.dto.UserAuthorizeDTO;
import com.simplify.mapper.UserMapper;
import com.simplify.model.entity.Business;
import com.simplify.model.entity.CustomerRecord;
import com.simplify.model.entity.User;
import com.simplify.service.*;
import com.simplify.service.BusinessService;
import com.simplify.service.CustomerRecordService;
import com.simplify.service.CustomerTasksService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@SpringBootTest
class PersuasibleCrmApplicationTests {

    @Autowired
    private CustomerService customerService;
    private CustomerRecordService customerRecordService;


    private CustomerTasksService customerTasksService;



    @Test
    void contextLoads() {
        System.out.println(customerService.selectALL());
    }

}
