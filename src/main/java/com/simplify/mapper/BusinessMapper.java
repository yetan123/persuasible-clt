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


    List<Business> selectAll();
    List<BusinessDTO> listBusiness();
    List<BusinessDTO> listBusinessById(Long id);

    void deleteBusinessById(Long id);
    int insertBusiness(Business business);
    int updateBusiness(Business business);
}
