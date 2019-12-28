package com.simplify.controller;

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
    public List<Business> listBusiness() {
        return businessService.listBusiness();
    }

    @ResponseBody
    @GetMapping("/listBusinessById")
    public List<Business> listBusinessById(Long id) {
        return businessService.listBusinessById(id);
    }

    @ResponseBody
    @GetMapping("/deleteBusinessById")
    public void deleteBusinessById(Long id) {
        businessService.deleteBusinessById(id);
        businessService.listBusiness();
    }

}
