package com.simplify.controller;

import com.simplify.model.dto.BusinessTaskDTO;
import com.simplify.model.dto.BusinessVO;
import com.simplify.model.vo.BusinessTaskVO;
import com.simplify.model.vo.PrincipalBusinessTaskVO;
import com.simplify.service.BusinessTaskService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商机任务控制器
 * @author yuntian
 * @date 2020-1-3
 */
@RestController
@RequestMapping("businessTask")
public class BusinessTaskController {

    @Autowired
    private BusinessTaskService businessTaskServiceImpl;
    @GetMapping("initBusinessTask")
    public Map<String,Object> initBusinessTask(Long businessId){
        List<BusinessTaskVO> businessTaskVOS =  businessTaskServiceImpl.listBusinessTask(businessId);
        List<PrincipalBusinessTaskVO> principalBusinessTaskVOS = businessTaskServiceImpl.listPrincipalBusinessTaskVO();
        Map<String,Object> result = new HashMap<>();
        result.put("businessTaskVOS",businessTaskVOS);
        result.put("principalBusinessTaskVOS",principalBusinessTaskVOS);
        return result;
    }

    @PostMapping("addBusinessTask")
    public Integer addBusinessTask(@RequestBody BusinessTaskDTO businessTaskDTO){
        return businessTaskServiceImpl.addBusinessTask(businessTaskDTO);
    }

    @DeleteMapping("removeBusinessById")
    public Integer deleteBusiness(Long id){
        System.out.println(id);
        return businessTaskServiceImpl.deleteBusinessTask(id);
    }

    @PutMapping("updateBusinessTask")
    public Integer updateBusinessTask(@RequestBody BusinessTaskDTO businessTaskDTO){
        return businessTaskServiceImpl.updateBusinessTask(businessTaskDTO);
    }

    @PutMapping("changeBusinessTask")
    public Integer changeBusinessTask(Long id){
        System.out.println(id);
        return businessTaskServiceImpl.changeBusinessTaskById(id);
    }
}
