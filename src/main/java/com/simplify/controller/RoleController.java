package com.simplify.controller;

import com.simplify.model.entity.Menu;
import com.simplify.model.entity.Role;
import com.simplify.model.vo.ResourceVO;
import com.simplify.model.vo.RoleAuthorizeVO;
import com.simplify.service.MenuService;
import com.simplify.service.ResourceService;
import com.simplify.service.RoleService;
import com.simplify.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @Autowired
    ResourceService resourceServiceImpl;
    @GetMapping("")
    public Map<String,Object> selectRoleAuthorize(@RequestParam(defaultValue = "1",value ="pageNum",required = false)Integer pageNum,
                                                  @RequestParam(value ="roleName",required = false)String roleName){
        PageBean<RoleAuthorizeVO> pages;
        Map<String,Object> roleMap = new HashMap<>();
        if (roleName!=null) {
            if (roleName=="" || roleName==null){
                roleName=null;
            }
            pages= roleServiceImpl.listRoleAuthorize(roleName,pageNum);
        }else{
            pages= roleServiceImpl.listRoleAuthorize(null,pageNum);
        }
        List<Menu> menus = menuServiceImpl.listMenu();
        List<ResourceVO> resourceVOS = resourceServiceImpl.listResourceViewObject();
        roleMap.put("roleAuthorize",pages);
        roleMap.put("menus",menus);
        roleMap.put("resources",resourceVOS);
        return roleMap;
    }
   /* public Map<String,Object> selectRoleAuthorize(@RequestParam(defaultValue = "1",value ="pageNum",required = false)Integer pageNum){
        Map<String,Object> roleMap = new HashMap<>();
        List<RoleAuthorizeVO> roleAuthorizeVOS = roleServiceImpl.listRoleAuthorize();
        List<Menu> menus = menuServiceImpl.listMenu();
        List<ResourceVO> resourceVOS = resourceServiceImpl.listResourceViewObject();
        roleMap.put("roleAuthorize",roleAuthorizeVOS);
        roleMap.put("menus",menus);
        roleMap.put("resources",resourceVOS);
        return roleMap;
    }*/
    @PutMapping("")
    @PreAuthorize("hasAuthority('修改角色:PUT')")
    public Integer updateRole(@RequestBody Role role){
        Integer integer = roleServiceImpl.updateRole(role);
        return integer;
    }

    @PreAuthorize("hasAuthority('删除角色:DELETE')")
    @DeleteMapping("{id}")
    public Integer removeRole(@PathVariable String id){
        Integer i = roleServiceImpl.removeRoleById(Long.parseLong(id));
        return i;
    }

    @PreAuthorize("hasAuthority('添加角色:POST')")
    @PostMapping("")
    public RoleAuthorizeVO addRole(@RequestBody Role role){
        return roleServiceImpl.insertRole(role);
    }
}
