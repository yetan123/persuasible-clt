package com.simplify.service;

import com.simplify.model.dto.BusinessDTO;
import com.simplify.model.entity.Business;

import java.util.List;
import java.util.Map;

/**
 * 商机表业务接口,提供对商机表的抽象方法
 * @author 杨泓
 * @date 2019-12-18
 */

public interface BusinessService {
    List<Business> selectALl();
    List<BusinessDTO> listBusiness();
    List<BusinessDTO> listBusinessById(Long id);
    void deleteBusinessById(Long id);
    int insertBusiness(Business business);
    int updateBusiness(Business business);

}