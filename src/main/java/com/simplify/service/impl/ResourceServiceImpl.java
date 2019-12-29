package com.simplify.service.impl;

import com.simplify.mapper.ResourceMapper;
import com.simplify.model.dto.RoleOfResourceDTO;
import com.simplify.model.entity.Resource;
import com.simplify.model.vo.ResourceVO;
import com.simplify.service.ResourceService;
import com.simplify.utils.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 资源业务接口实现类
 * @author yuntian
 * @date 2019-12-24
 */
@Service
@Transactional(rollbackFor = {Exception.class})
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private ResourceMapper resourceMapper;
    @Override
    public List<Resource> listResourceByRoleId(Long userId) {
       return resourceMapper.listResourceByUserId(userId);
    }

    @Override
    public List<Resource> listResource() {
        return resourceMapper.selectAll();
    }

    @Override
    public List<ResourceVO> listResourceViewObject() {
        return resourceMapper.listResourceViewObject();
    }

    /**
     * 修改角色权限,分配权限
     * @param roleOfResourceDTO
     * @return 受影响行
     */
    @CacheEvict(value = {"roleAuthorize"},allEntries = true)
    @Override
    public Integer updateRoleOfResource(RoleOfResourceDTO roleOfResourceDTO) {
        SnowFlake snowFlake = new SnowFlake(0,0);
        int count = 0;
        for (long resourceId : roleOfResourceDTO.getResourceIds()){
            long id = snowFlake.nextId();
            roleOfResourceDTO.setId(id);
            roleOfResourceDTO.setResourceId(resourceId);
            resourceMapper.insertRoleOfResource(roleOfResourceDTO);
            count++;
        }
        count += resourceMapper.removeRoleOfResource(roleOfResourceDTO);
        return count;
    }
}
