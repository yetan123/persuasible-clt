package com.simplify.controller;

import com.simplify.model.dto.BusinessDTO;
import com.simplify.model.dto.BusinessInfoDTO;
import com.simplify.model.dto.BusinessVO;
import com.simplify.model.vo.BusinessLinkmanVO;
import com.simplify.service.BusinessDTOService;
import com.simplify.service.BusinessService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商机控制器,负责对商机实体的业务分发
 * @author yanghong
 * @date 2019-12-18
 */
@RestController
@RequestMapping("business")
@CrossOrigin
public class BusinessController {

    @Resource
    BusinessService businessServiceImpl;

    @Resource
    BusinessDTOService businessDTOService;

    @PreAuthorize("hasAuthority('查看全部商机:GET')")
    @GetMapping("listBusiness")
    public List<BusinessVO> listBusiness() {
        return businessServiceImpl.listBusiness();
    }

    @GetMapping("/listBusinessById")
    public List<BusinessVO> listBusinessById(Long id) {
        return businessServiceImpl.listBusinessById(id);
    }


    @ResponseBody
    @GetMapping("/deleteBusinessById")
    public void deleteBusinessById(Long id) {
        businessServiceImpl.deleteBusinessById(id);
    }

    @PostMapping("insertBusiness")
    public void insertBusiness(@RequestBody BusinessInfoDTO businessInfoDTO) {
        System.out.println(businessInfoDTO);
        businessServiceImpl.insertBusiness(businessInfoDTO);
    }


    @GetMapping("getBusinessDTO")
    public BusinessDTO getBusinessDTO(){
        BusinessDTO businessDTO = new BusinessDTO();
        businessDTO.setCustomer(businessDTOService.listCustomerIDAndCustomerName());
        businessDTO.setBusinessType(businessDTOService.listBusinessType());
        businessDTO.setBusinessSource(businessDTOService.listBusinessSource());
        return businessDTO;
    }

    @GetMapping("getLinkman")
    public List<BusinessLinkmanVO> getLinkman(Long id){
        return businessDTOService.getLinkmanByCustomerId(id);
    }

    @PutMapping("updateBusiness")
    public void updateBusiness(@RequestBody BusinessInfoDTO businessInfoDTO) {
        businessServiceImpl.updateBusiness(businessInfoDTO);
    }

}
