package com.simplify.controller;

import com.simplify.model.dto.RoleOfMenuDTO;
import com.simplify.model.dto.RouteDTO;
import com.simplify.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 菜单控制器
 * @author yuntian
 * @date 2019-12-18
 * CrossOrigin注解解决跨域问题
 */
@CrossOrigin
@RestController
@RequestMapping("menu")
public class MenuController {
    @Autowired
    private MenuService menuServiceImpl;
    @GetMapping("")
    public List<RouteDTO> getMenuList(){
        List<RouteDTO> menus = menuServiceImpl.listRoute();
        Map<Long,List<String>> menuCacheMap = menuServiceImpl.listPermission(menus);
        menus.forEach((menu)-> menu.setPermission(menuCacheMap.get(menu.getId())));
        return menus;
    }
    @PreAuthorize("hasAuthority('菜单分配:PUT')")
    @PutMapping("")
    public Integer handleMenu(@RequestBody RoleOfMenuDTO roleOfMenuDTO){
        return menuServiceImpl.handleMenu(roleOfMenuDTO);
    }
}
