package com.simplify.controller;

import com.simplify.model.dto.ContractDTO;
import com.simplify.model.entity.Contract;
import com.simplify.model.entity.Linkman;
import com.simplify.service.impl.ContractDTOServiceImpl;
import com.simplify.service.impl.ContractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("contract")
@CrossOrigin
public class ContractController {

    @Autowired
    private ContractServiceImpl contractServiceImpl;

    @Autowired
    private ContractDTOServiceImpl contractDTOServiceImpl;

    @GetMapping(value = "/listContractById")
    public List<Contract> listContract(Long id){
        //System.out.println(id);
        return contractServiceImpl.listContractById(id);
    }

    @GetMapping(value = "/listContract")
    public List<Contract> listContract(){
        return contractServiceImpl.listContract();
    }

    @PostMapping(value = "/getContractDTO")
    public ContractDTO getContractDTO(){

        System.out.println("进入getContractDTO（）方法");
        ContractDTO contractDTO = new ContractDTO();
        contractDTO.setCustomer(contractDTOServiceImpl.listCustomerIDAndCustomerName());
        contractDTO.setBusiness(contractDTOServiceImpl.listBusiness());
        contractDTO.setContractState(contractDTOServiceImpl.listContractState());
        contractDTO.setContractType(contractDTOServiceImpl.listContractType());

        contractDTO.setUser(contractDTOServiceImpl.listUser());
        return contractDTO;
    }

    @GetMapping(value = "/getLinkman")
    public Linkman getLinkman(Long CustomerId){
        return contractDTOServiceImpl.getLinkmanByCustomerId(CustomerId);
    }
}
