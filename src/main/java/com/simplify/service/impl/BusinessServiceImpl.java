package com.simplify.service.impl;

import com.simplify.mapper.BusinessMapper;
import com.simplify.model.dto.BusinessInfoDTO;
import com.simplify.model.dto.BusinessStateDTO;
import com.simplify.model.dto.BusinessVO;
import com.simplify.model.entity.Business;
import com.simplify.model.vo.BusinessDetailsVO;
import com.simplify.service.BusinessService;
import com.simplify.utils.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;
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
    public BusinessDetailsVO findBusinessDetails(Long id) {
        return businessMapper.findBusinessDetails(id);
    }

    @Override
    public Integer changeBusinessState(BusinessStateDTO businessStateDTO) {
        return businessMapper.updateBusinessState(businessStateDTO);
    }

    @Override
    public List<Business> selectALl() {
        return businessMapper.selectAll();
    }

    @Cacheable("listBusiness")
    @Override
    public List<BusinessVO> listBusiness() {
        return businessMapper.listBusiness();
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
    }

    @CacheEvict(cacheNames = {"listBusiness", "listBusinessById"})
    @Override
    public int insertBusiness (BusinessInfoDTO businessInfoDTO){
        Long id=new SnowFlake(0,0).nextId();
        businessInfoDTO.setId(id);
        return businessMapper.insertBusiness(businessInfoDTO);
    }

    @CacheEvict(cacheNames = {"listBusiness", "listBusinessById"})
    @Override
    public int updateBusiness (BusinessInfoDTO businessInfoDTO){
        return businessMapper.updateBusiness(businessInfoDTO);
    }

}
