package com.simplify.service;

import com.simplify.model.dto.BusinessDTO;
import com.simplify.model.dto.BusinessInfoDTO;
import com.simplify.model.dto.BusinessStateDTO;
import com.simplify.model.dto.BusinessVO;
import com.simplify.model.entity.Business;
import com.simplify.model.vo.BusinessDetailsVO;

import java.util.List;
import java.util.Map;

/**
 * 商机表业务接口,提供对商机表的抽象方法
 * @author 杨泓
 * @date 2019-12-18
 */

public interface BusinessService {


    BusinessDetailsVO findBusinessDetails(Long id);

    Integer changeBusinessState(BusinessStateDTO businessStateDTO);

    List<Business> selectALl();
//    List<BusinessVO> listBusiness();
//    List<BusinessVO> listBusinessById(Long id);
    List<BusinessVO> listBusiness(Map map);
    List<BusinessVO> listBusinessById(Map map);
    void deleteBusinessById(Long id);
    int insertBusiness(BusinessInfoDTO businessInfoDTO);
    int updateBusiness(BusinessInfoDTO businessInfoDTO);
}