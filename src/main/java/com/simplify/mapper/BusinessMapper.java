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
    List<Business> selectAll();

    //查询商机所有数据及实现分页功能
    List<Business> listBusiness();

    //根据id查询商机数据
    List<Business> listBusinessById(Long id);
<<<<<<< HEAD
=======

    //根据id删除商机数据
>>>>>>> 9f0fdb08f34d541149952e1b97044fa374f3f56c
    void deleteBusinessById(Long id);
}
