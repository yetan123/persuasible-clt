package com.simplify.service;

import com.simplify.model.dto.RoleOfResourceDTO;
import com.simplify.model.entity.Resource;
import com.simplify.model.vo.ResourceVO;

import java.util.List;

/**
 * 资源业务接口，资源即细粒度权限
 * @author yuntian
 * @date 2019-12-24
 */
public interface ResourceService {
    List<Resource> listResourceByRoleId(Long userId);
    List<Resource> listResource();
    List<ResourceVO> listResourceViewObject();
    Integer updateRoleOfResource(RoleOfResourceDTO roleOfResourceDTO);
}
