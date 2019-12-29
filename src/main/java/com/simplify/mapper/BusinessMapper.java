package com.simplify.mapper;


import com.simplify.model.entity.Business;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 商机映射层
 * @author 杨泓
 * @date 2019-12-18
 */

@Repository
public interface BusinessMapper extends Mapper<Business> {

    //查询商机所有数据及实现分页功能
    List<Business> listBusiness();

    //根据id查询商机数据
    List<Business> listBusinessById(Long id);

    void deleteBusinessById(Long id);
}
