package com.simplify.service;

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

    //查询商机所有数据及实现分页功能
    List<Business> listBusiness();

    //根据id查询商机数据
    List<Business> listBusinessById(Long id);

    //根据id删除商机数据
    void deleteBusinessById(Long id);

}