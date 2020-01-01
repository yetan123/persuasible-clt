package com.simplify.controller;

import com.simplify.model.dto.ContractDTO;
import com.simplify.model.dto.ContractVO;
import com.simplify.model.entity.Contract;
import com.simplify.model.entity.Linkman;
import com.simplify.service.impl.ContractDTOServiceImpl;
import com.simplify.service.impl.ContractServiceImpl;
import com.simplify.utils.SnowFlake;
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

        //System.out.println("进入getContractDTO（）方法");
        ContractDTO contractDTO = new ContractDTO();
        contractDTO.setCustomer(contractDTOServiceImpl.listCustomerIDAndCustomerName());
        contractDTO.setBusiness(contractDTOServiceImpl.listBusiness());
        contractDTO.setContractState(contractDTOServiceImpl.listContractState());
        contractDTO.setContractType(contractDTOServiceImpl.listContractType());
        contractDTO.setUser(contractDTOServiceImpl.listUser());
        Long ContractCode  = new SnowFlake(0,0).nextId();
        contractDTO.setContractNo(ContractCode.toString());
        return contractDTO;
    }

    @GetMapping(value = "/getLinkman")
    public List<Linkman> getLinkman(Long id){
        System.out.println("客户编号"+id);
        return contractDTOServiceImpl.getLinkmanByCustomerId(id);
    }

    @PostMapping(value = "/insertContract")
    public int insertContract(@RequestBody ContractVO contractvo){
        contractvo.setPrincipalId(contractvo.getCreatorId());
        contractvo.setFollowTime(contractvo.getContractDate());
        System.out.println(contractvo.toString());
        return contractServiceImpl.insertContract(contractvo);
    }

    @PostMapping(value = "/deleteContratById")
    public int deleteContratById(String id){
        System.out.println(id);
        return contractServiceImpl.deleteContractByContractCode(id);
    }

    @GetMapping(value = "/getContractByCode")
    public ContractVO getContractByCode(String code){
        //System.out.println("合同编号"+code);
        return contractServiceImpl.getContractByCode(code);
    }

    @PostMapping(value = "/updateContract")
    public int getContractByCode(@RequestBody ContractVO contract){
        System.out.println("对象"+contract);
        return contractServiceImpl.updateContract(contract);
    }
}
