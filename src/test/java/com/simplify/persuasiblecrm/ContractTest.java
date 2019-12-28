package com.simplify.persuasiblecrm;

import com.simplify.mapper.ContractConverMapper;
import com.simplify.mapper.ContractDTOMapper;
import com.simplify.model.entity.*;
import com.simplify.service.impl.ContractConverServiceImpl;
import com.simplify.service.impl.ContractDTOServiceImpl;
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

    @Autowired
    private ContractDTOServiceImpl contractDTOServiceImpl;

    @Test
    public void listContract(){
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }

    @Test
    public void listContractById(){
//        String id = "1";
//        List<Contract> list = contractServiceImpl.listContractById(id);
//        System.out.println(list);
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

    @Test
    public void getLinkmanByCustomerId(){
        long id = 407157154483535872L;
        Linkman list = contractDTOServiceImpl.getLinkmanByCustomerId(id);
        System.out.println(list);
    }

    @Test
    public void listCustomerIDAndCustomerName(){
        List<Customer> list = contractDTOServiceImpl.listCustomerIDAndCustomerName();
        for (Customer c:list){
            System.out.println(c.getId()+""+c.getCompanyName());
        }
    }

    @Test
    public void listBusiness(){
        List<Business> list = contractDTOServiceImpl.listBusiness();
        for (Business c:list){
            System.out.println(c.getId()+""+c.getBusinessName());
        }
    }

    @Test
    public void listContractType(){
        List<ContractType> list = contractDTOServiceImpl.listContractType();
        for (ContractType c:list){
            System.out.println(c.getId()+""+c.getContractType());
        }
    }

    @Test
    public void listContractState(){
        List<ContractState> list = contractDTOServiceImpl.listContractState();
        for (ContractState c:list){
            System.out.println(c.getId()+""+c.getContractState());
        }
    }
}
