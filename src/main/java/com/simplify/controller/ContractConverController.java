package com.simplify.controller;

import com.simplify.model.entity.ContractConver;
import com.simplify.service.impl.ContractConverServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "ContractConver")
@CrossOrigin
public class ContractConverController {

    @Autowired
    private ContractConverServiceImpl contractConverServiceImpl;

    @GetMapping(value = "/listMeConvert")
    public List<ContractConver> listMeConvert(Long id){

        System.out.println("用户编号："+id);
        return contractConverServiceImpl.listMeConvert(id);
    }

    @GetMapping(value = "/listConvertMe")
    public List<ContractConver> listConvertMe(Long id){

        System.out.println("用户编号："+id);
        return contractConverServiceImpl.listConvertMe(id);
    }
}
