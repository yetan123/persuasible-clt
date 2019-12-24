package com.simplify.persuasiblecrm;

import com.simplify.mapper.ContractConverMapper;
import com.simplify.model.entity.Contract;
import com.simplify.model.entity.ContractConver;
import com.simplify.service.impl.ContractConverServiceImpl;
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

    @Autowired
    private ContractConverServiceImpl contractConverServiceImpl;

    @Test
    public void listContract(){
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }

    @Test
    public void listContractById(){
        long id = 1;
        List<Contract> list = contractServiceImpl.listContractById(id);
        System.out.println(list);
    }

    @Test
    public void deleteContractByContractCode(){
        String contractCode = "";
        contractServiceImpl.deleteContractByContractCode(contractCode);
    }

    @Test
    public void listConvertMe(){
        long receiveUserId = 1;
        List<ContractConver> list = contractConverServiceImpl.listConvertMe(receiveUserId);
        System.out.println(list);
    }

    @Test
    public void listMeConvert(){
        long converUserId = 1;
        List<ContractConver> list = contractConverServiceImpl.listMeConvert(converUserId);
        System.out.println(list);
    }
}
