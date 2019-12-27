package com.simplify.persuasiblecrm;

import com.simplify.model.entity.Customer;
import com.simplify.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class CustomerMethodTest {
    @Resource
    CustomerService customerService;
    @Test
    public void method() {
        Map params = new HashMap();
        params.put("userId", 1);
        customerService.listConver(params);
    }


}
