package com.simplify.controller;

import com.simplify.model.entity.Menu;
import com.simplify.model.entity.Role;
import com.simplify.model.vo.RoleAuthorizeVO;
import com.simplify.service.MenuService;
import com.simplify.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色控制器
 * @author yuntian
 * @date 2019-12-23
 */
@RestController
@CrossOrigin
@RequestMapping("role")
public class RoleController {
    @Autowired
    RoleService roleServiceImpl;
    @Autowired
    MenuService menuServiceImpl;
    @GetMapping("")
    public Map<String,Object> selectRoleAuthorize(){
        Map<String,Object> roleMap = new HashMap<>();
        List<RoleAuthorizeVO> roleAuthorizeVOS = roleServiceImpl.listRoleAuthorize();
        List<Menu> menus = menuServiceImpl.listMenu();
        roleMap.put("roleAuthorize",roleAuthorizeVOS);
        roleMap.put("menus",menus);
        return roleMap;
    }
    @PutMapping("")
    public Integer updateRole(@RequestBody Role role){
        Integer integer = roleServiceImpl.updateRole(role);
        return integer;
    }
}
