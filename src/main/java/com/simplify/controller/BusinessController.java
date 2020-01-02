package com.simplify.controller;

import com.simplify.model.dto.BusinessDTO;
import com.simplify.model.dto.BusinessVO;
import com.simplify.model.entity.Business;
import com.simplify.model.entity.Linkman;
import com.simplify.service.BusinessDTOService;
import com.simplify.service.BusinessService;
import com.simplify.utils.SnowFlake;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.util.List;

/**
 * 商机控制器,负责对商机实体的业务分发
 * @author yanghong
 * @date 2019-12-18
 */
@Controller
@RequestMapping("business")
@CrossOrigin
public class BusinessController {

    @Resource
    BusinessService businessService;

    @Resource
    BusinessDTOService businessDTOService;

    @ResponseBody
    @GetMapping("/deleteBusinessById")
    public void deleteBusinessById(Long id) {
        businessService.deleteBusinessById(id);
    }

    @ResponseBody
    @GetMapping("/insertBusiness")
    public void insertBusiness(BusinessVO businessVO) {
        Long id=new SnowFlake(0,0).nextId();
        businessVO.setId(id);
        businessService.insertBusiness(businessVO);
    }

    @PostMapping(value = "/getBusinessDTO")
    public BusinessDTO getBusinessDTO(){

        System.out.println("进入getBusinessDTO（）方法");
        BusinessDTO businessDTO = new BusinessDTO();
        businessDTO.setCustomer(businessDTOService.listCustomerIDAndCustomerName());
        businessDTO.setBusinessType(businessDTOService.listBusinessType());
        businessDTO.setBusinessSource(businessDTOService.listBusinessSource());
        businessDTO.setUser(businessDTOService.listUser());
        return businessDTO;
    }

    @GetMapping(value = "/getLinkman")
    public List<Linkman> getLinkman(Long id){
        //System.out.println("客户编号"+id);
        return businessDTOService.getLinkmanByCustomerId(id);
    }

    @ResponseBody
    @GetMapping("/updateBusiness")
    public void updateBusiness(BusinessVO businessVO) {
        businessService.updateBusiness(businessVO);
    }

}
