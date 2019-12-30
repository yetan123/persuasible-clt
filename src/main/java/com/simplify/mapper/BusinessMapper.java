package com.simplify.mapper;


import com.simplify.model.dto.BusinessDTO;
import com.simplify.model.entity.Business;
import org.apache.ibatis.annotations.Param;
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
<<<<<<< HEAD

    List<Business> selectAll();
    List<BusinessDTO> listBusiness();
    List<BusinessDTO> listBusinessById(Long id);
=======

    //查询商机所有数据及实现分页功能
    List<Business> listBusiness();

    //根据id查询商机数据
    List<Business> listBusinessById(Long id);

>>>>>>> 61b4f2eb79ef8f1e927ae30fc5a88a741bc359d3
    void deleteBusinessById(Long id);
}
