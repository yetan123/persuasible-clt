package com.simplify.controller;

import com.simplify.service.impl.ContractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContractController {

    @Autowired
    private ContractServiceImpl contractServiceImpl;

//    @RequestMapping(value = "")
//    public String listContract(){
//        return "";
//    }
}
