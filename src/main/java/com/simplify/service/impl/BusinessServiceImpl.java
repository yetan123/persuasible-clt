package com.simplify.service.impl;

import com.simplify.mapper.BusinessMapper;
import com.simplify.model.dto.BusinessInfoDTO;
import com.simplify.model.dto.BusinessVO;
import com.simplify.model.entity.Business;
import com.simplify.service.BusinessService;
import com.simplify.utils.SnowFlake;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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

    @Cacheable("listBusiness")
    @Override
    public List<BusinessVO> listBusiness() {
        return null;
    }

    @Cacheable("listBusinessById")
    @Override
    public List<BusinessVO> listBusinessById(Long id) {
        return businessMapper.listBusinessById(id);
    }
    @CacheEvict(cacheNames = {"listBusiness", "listBusinessById"})
    @Override
    public void deleteBusinessById (Long id){
        businessMapper.deleteBusinessById(id);
        return null;
    }

    @Override
    public void deleteBusinessById(Long id) {
    }

    @CacheEvict(cacheNames = {"listBusiness", "listBusinessById"})
    @Override
    public int insertBusiness (BusinessInfoDTO businessInfoDTO){
        Long id=new SnowFlake(0,0).nextId();
        businessInfoDTO.setId(id);
        return businessMapper.insertBusiness(businessInfoDTO);
    public int insertBusiness(BusinessVO businessVO) {
        return 0;
    }

    @CacheEvict(cacheNames = {"listBusiness", "listBusinessById"})
    @Override
    public int updateBusiness (BusinessInfoDTO businessInfoDTO){
        return businessMapper.updateBusiness(businessInfoDTO);
    }
    public int updateBusiness(BusinessVO businessVO) {
        return 0;
    }
}
