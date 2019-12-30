package com.simplify.mapper;

import com.simplify.model.dto.RoleOfMenuDTO;
import com.simplify.model.dto.RouteDTO;
import com.simplify.model.entity.Menu;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 菜单路由持久层访问接口
 * @author yuntian
 * @date 2019-12-18
 */
@Repository
public interface MenuMapper extends Mapper<Menu> {
    List<RouteDTO> listRouteDTO();

    Integer insertMenuSelectivity(RoleOfMenuDTO roleOfMenuDTO);

    Integer removeMenuSelectivity(RoleOfMenuDTO roleOfMenuDTO);

    List<String> listPermission(Long id);
}
