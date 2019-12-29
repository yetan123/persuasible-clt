package com.simplify.persuasiblecrm;


import com.simplify.model.dto.UserAuthorizeDTO;
import com.simplify.mapper.UserMapper;
import com.simplify.model.entity.Business;
import com.simplify.model.entity.CustomerRecord;
import com.simplify.model.entity.User;
import com.simplify.service.*;
<<<<<<< HEAD

=======
import com.simplify.service.BusinessService;
>>>>>>> ea361d9eb07b242bcdff1e08dba97400d308c761
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
        CustomerRecord c = new CustomerRecord();
        c.setCustomerId(5l);
        c.setRecordContent("测试");
        c.setRecordType("QQ");
        c.setRecordProgress("开始测试");
        c.setCustomerId(407016855044096000l);
        c.setLinkmanId(407016855044096000l);

        System.out.println(c);
        int i = customerRecordService.insertCustomerRecord(c);
    }

}
