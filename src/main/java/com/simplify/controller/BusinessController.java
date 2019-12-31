package com.simplify.controller;

import com.simplify.model.dto.BusinessDTO;
import com.simplify.model.entity.Business;
import com.simplify.service.BusinessService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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

    @ResponseBody
    @GetMapping("/listBusiness")
    public List<BusinessDTO> listBusiness() {
        return businessService.listBusiness();
    }

    @ResponseBody
    @GetMapping("/listBusinessById")
    public List<BusinessDTO> listBusinessById(Long id) {
        return businessService.listBusinessById(id);
    }

    @ResponseBody
    @GetMapping("/deleteBusinessById")
    public void deleteBusinessById(Long id) {
        businessService.deleteBusinessById(id);
    }

    @ResponseBody
    @GetMapping("/insertBusiness")
    public void insertBusiness(Business business) {
        businessService.insertBusiness(business);
    }

    @ResponseBody
    @GetMapping("/updateBusiness")
    public void updateBusiness(Business business) {
        businessService.updateBusiness(business);
    }

}
