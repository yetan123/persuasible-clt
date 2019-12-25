package com.simplify.service;

import com.simplify.model.entity.Business;

import java.util.List;

/**
 * 商机表业务接口,提供对商机表的抽象方法
 * @author 杨泓
 * @date 2019-12-18
 */

public interface BusinessService {
    List<Business> listBusiness();
    List<Business> listBusinessById(Long id);
}