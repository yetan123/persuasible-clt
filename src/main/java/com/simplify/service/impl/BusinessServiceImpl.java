package com.simplify.service.impl;

import com.simplify.mapper.BusinessMapper;
import com.simplify.model.entity.Business;
import com.simplify.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商机业务实现类,是商机业务接口的具体实现
 * @author 杨泓
 * @date 2019-12-18
 */
@Service
public class BusinessServiceImpl implements BusinessService {

    @Resource
    private BusinessMapper businessMapper;

    @Override
    public List<Business> selectALl() {
        return businessMapper.selectAll();
    }

    @Override
    public List<Business> listBusiness() {
        return businessMapper.listBusiness();
    }

    @Override
    public List<Business> listBusinessById(Long id) {
        return businessMapper.listBusinessById(id);
    }

    @Override
    public void deleteBusinessById(Long id) {
        businessMapper.deleteBusinessById(id);
    }
}
