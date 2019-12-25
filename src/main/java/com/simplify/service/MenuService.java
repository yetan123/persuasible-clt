package com.simplify.service;

import com.simplify.model.dto.RouteDTO;
import com.simplify.model.entity.Menu;

import java.util.List;

/**
 * 菜单服务接口
 * @author yuntian
 * @date 2019-12-18
 */
public interface MenuService {
   List<RouteDTO> listRoute();

   List<Menu> listMenu();
}
