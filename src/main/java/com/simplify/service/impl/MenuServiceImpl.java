package com.simplify.service.impl;

import com.simplify.mapper.MenuMapper;
import com.simplify.model.entity.Menu;
import com.simplify.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Override
    public List<Menu> listMenu() {
        return menuMapper.selectAll();
    }
}
