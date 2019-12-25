package com.simplify.service.impl;

import com.simplify.mapper.MenuMapper;
import com.simplify.model.dto.RouteDTO;
import com.simplify.model.entity.Menu;
import com.simplify.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 菜单业务接口实现类
 * @author yuntian
 * @date 2019-12-18
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    /**
     * 使用了Spring缓存机制,大大增加了程序的性能
     * @return
     */
    @Cacheable(value = "menuList")
    @Override
    public List<RouteDTO> listRoute() {
        return menuMapper.listRouteDTO();
    }

    @Cacheable(value = "menu")
    @Override
    public List<Menu> listMenu() {
        Example example = new Example(Menu.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("component","Layout");
        return menuMapper.selectByExample(example);
    }
}
