package com.simplify.persuasiblecrm;

import com.simplify.model.entity.Contract;
import com.simplify.service.impl.ContractServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ContractTest {

    @Autowired
    private ContractServiceImpl contractServiceImpl;

    @Test
    public void listContract(){

        List<Contract> list = contractServiceImpl.listContract();
        System.out.println(list);
    }

}
