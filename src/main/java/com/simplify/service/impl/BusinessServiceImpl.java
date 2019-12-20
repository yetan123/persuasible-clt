package com.simplify.service.impl;

import com.simplify.mapper.BusinessMapper;
import com.simplify.model.entity.Business;
import com.simplify.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商机业务实现类,是商机业务接口的具体实现
 * @author 杨泓
 * @date 2019-12-18
 */
@Service
public class BusinessServiceImpl implements BusinessService {
    @Autowired
    private BusinessMapper businessMapper;

    @Override
    public List<Business> selectAll() {
        return businessMapper.selectAll();
    }
}
