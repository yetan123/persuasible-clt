package com.simplify.service.impl;

import com.simplify.mapper.ResourceMapper;
import com.simplify.model.entity.Resource;
import com.simplify.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 资源业务接口实现类
 * @author yuntian
 * @date 2019-12-24
 */
@Service
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
}
