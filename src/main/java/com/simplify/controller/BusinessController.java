package com.simplify.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simplify.model.dto.BusinessDTO;
import com.simplify.model.dto.BusinessInfoDTO;
import com.simplify.model.dto.BusinessStateDTO;
import com.simplify.model.dto.BusinessVO;
import com.simplify.model.vo.BusinessDetailsCustomerVO;
import com.simplify.model.vo.BusinessDetailsVO;
import com.simplify.model.vo.BusinessLinkmanVO;
import com.simplify.service.BusinessDTOService;
import com.simplify.service.BusinessService;
import org.springframework.security.access.prepost.PreAuthorize;
import com.simplify.utils.SnowFlake;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
    @PostMapping("listBusiness")
    public PageInfo<BusinessVO> listBusiness(@RequestBody Map params) {
        return getPageInfo(params, "all");
    }

    @PostMapping("/listBusinessById")
    public PageInfo<BusinessVO> listBusinessById(@RequestBody Map params) {
        return getPageInfo(params, "my");
    }

    private PageInfo<BusinessVO> getPageInfo(Map map, String type) {
        Integer pageNum = map.get("pageNum") == null ? 0 : Integer.valueOf(map.get("pageNum").toString());
        Integer pageSize = map.get("pageSize") == null ? 5 : Integer.valueOf(map.get("pageSize").toString());
        PageHelper.startPage(pageNum, pageSize, true);
        PageInfo<BusinessVO> pageInfo = null;
        if ("all".equals(type)) {
            pageInfo = new PageInfo<>(businessServiceImpl.listBusiness(map));
        } else if ("my".equals(type)) {
            pageInfo = new PageInfo<>(businessServiceImpl.listBusinessById(map));
        }
        return pageInfo;
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

    @GetMapping("getBusinessDetailsCustomerVOList")
    public BusinessDetailsVO businessDetailsCustomerVOList(Long id){
        BusinessDetailsVO businessDetails = businessServiceImpl.findBusinessDetails(id);
        return businessDetails;
    }

    @PutMapping("changeBusinessState")
    public Integer changeBusinessState(@RequestBody BusinessStateDTO businessStateDTO){
        System.out.println(businessStateDTO);
        return businessServiceImpl.changeBusinessState(businessStateDTO);
    }
}