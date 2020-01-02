package com.simplify.service.impl;

import com.simplify.mapper.BusinessMapper;
import com.simplify.model.dto.BusinessVO;
import com.simplify.model.entity.Business;
import com.simplify.service.BusinessService;
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
    public void deleteBusinessById(Long id) {
        businessMapper.deleteBusinessById(id);
    }

    @Override
    public int insertBusiness(BusinessVO businessVO) {
        return businessMapper.insertBusiness(businessVO);
    }

    @Override
    public int updateBusiness(BusinessVO businessVO) {
        return businessMapper.updateBusiness(businessVO);
    }
}
