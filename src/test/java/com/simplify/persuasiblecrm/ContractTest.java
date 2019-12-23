package com.simplify.persuasiblecrm;

import com.simplify.model.entity.Contract;
import com.simplify.service.impl.ContractServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootTest
public class ContractTest {

    @Autowired
    private ContractServiceImpl contractServiceImpl;

    @Test
    public void listContract(){
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }

}
