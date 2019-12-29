package com.simplify.service.impl;

import com.simplify.mapper.MenuMapper;
import com.simplify.model.dto.RoleOfMenuDTO;
import com.simplify.model.dto.RouteDTO;
import com.simplify.model.entity.Menu;
import com.simplify.service.MenuService;
import com.simplify.utils.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 菜单业务接口实现类
 * @author yuntian
 * @date 2019-12-18
 */
@Service
@Transactional(rollbackFor = {Exception.class})
public class MenuServiceImpl implements MenuService
{
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

    /**
     * 处理菜单权限,控制菜单权限分配
     * @param roleOfMenuDTO
     * @return 受响应行
     */
    @CacheEvict(value = {"menuList"},allEntries = true)
    @Override
    public Integer handleMenu(RoleOfMenuDTO roleOfMenuDTO) {
        SnowFlake snowFlake = new SnowFlake(0,0);
        int count = 0;
        for (long resourceId : roleOfMenuDTO.getMenuIds()){
            long id = snowFlake.nextId();
            roleOfMenuDTO.setId(id);
            roleOfMenuDTO.setMenuId(resourceId);
            menuMapper.insertMenuSelectivity(roleOfMenuDTO);
            count++;
        }
        count += menuMapper.removeMenuSelectivity(roleOfMenuDTO);
        return count;
    }
}
