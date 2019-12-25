package com.simplify.controller;

import com.simplify.model.entity.Contract;
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

    @GetMapping(value = "/listContractById")
    public List<Contract> listContract(Long id){
        //System.out.println(id);
        return contractServiceImpl.listContractById(id);
    }

    @GetMapping(value = "/listContract")
    public List<Contract> listContract(){
        return contractServiceImpl.listContract();
    }
}
