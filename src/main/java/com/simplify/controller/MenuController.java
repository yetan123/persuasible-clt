package com.simplify.controller;

import com.simplify.model.dto.RouteDTO;
import com.simplify.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        List<RouteDTO> menus = menuServiceImpl.listMenu();
        System.out.println(menus);
        menus.forEach((menu)-> System.out.println(menu));
        return menus;
    }
}
