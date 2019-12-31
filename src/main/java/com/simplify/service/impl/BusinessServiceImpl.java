package com.simplify.service.impl;

import com.simplify.mapper.BusinessMapper;
import com.simplify.model.dto.BusinessDTO;
import com.simplify.model.entity.Business;
import com.simplify.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
    public List<BusinessDTO> listBusiness() {
        return businessMapper.listBusiness();
    }

    @Override
    public List<BusinessDTO> listBusinessById(Long id) {
        return businessMapper.listBusinessById(id);
    }

    @Override
    public void deleteBusinessById(Long id) {
        businessMapper.deleteBusinessById(id);
    }

    @Override
    public int insertBusiness(Business business) {
        return businessMapper.insertBusiness(business);
    }

    @Override
    public int updateBusiness(Business business) {
        return businessMapper.updateBusiness(business);
    }
}
