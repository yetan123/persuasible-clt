package com.simplify.controller;

import com.simplify.model.dto.RoleOfResourceDTO;
import com.simplify.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 资源权限控制器
 * @author yuntian
 * @date 2019-12-25
 */
@RestController
@RequestMapping("resource")
public class ResourceController {
    @Autowired
    ResourceService resourceServiceImpl;
    @PutMapping("")
    @PreAuthorize("hasAuthority('权限分配:PUT')")
    public Integer updateResource(@RequestBody RoleOfResourceDTO roleOfResourceDTO){
        return resourceServiceImpl.updateRoleOfResource(roleOfResourceDTO);
    }
}
