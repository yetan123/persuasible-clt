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
//@Service
//public class BusinessServiceImpl implements BusinessService {
//
//    @Resource
//    private BusinessMapper businessMapper;
//
//    @Override
//    public List<Business> selectALl() {
//        return businessMapper.selectAll();
//    }
//
//    @Override
//    public List<BusinessVO> listBusiness() {
//        return businessMapper.listBusiness();
//    }
//
//    @Override
//    public List<BusinessVO> listBusinessById(Long id) {
//        return businessMapper.listBusinessById(id);
//
//    public List<BusinessDTO> listBusiness() {
//        return null;
//    }
//
//    @Override
//    public List<BusinessDTO> listBusinessById(Long id) {
//        return null;
//    }
//
//
//    @Override
//    public void deleteBusinessById(Long id) {
//        businessMapper.deleteBusinessById(id);
//    }
//
//    @Override
//    public int insertBusiness(BusinessVO businessVO) {
//        return businessMapper.insertBusiness(businessVO);
//    }
//
//    @Override
//    public int updateBusiness(BusinessVO businessVO) {
//        return businessMapper.updateBusiness(businessVO);
//    }

<<<<<<< HEAD
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
=======
>>>>>>> e52cc5832427de982b3f1dce136f5ba52aa52078
