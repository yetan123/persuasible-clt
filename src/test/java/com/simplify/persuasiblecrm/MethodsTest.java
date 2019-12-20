package com.simplify.persuasiblecrm;

import com.simplify.model.entity.Customer;
import com.simplify.service.CustomerService;
import com.simplify.service.CustomerTasksService;
import com.simplify.service.LinkmanService;
import com.simplify.utils.SnowFlake;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class MethodsTest {
    @Resource
    CustomerService customerService;

    @Test
    void contextLoads() {
        List<Customer> customers = customerService.listCustomerAndLinkman(new Long(1));
        for(Customer customer: customers) {
            System.out.println(customer);
        }
    }

}
