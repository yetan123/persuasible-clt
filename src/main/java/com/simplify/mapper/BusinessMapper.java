package com.simplify.mapper;


import com.simplify.model.entity.Business;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 商机映射层
 * @author 杨泓
 * @date 2019-12-18
 */

@Repository
public interface BusinessMapper extends Mapper<Business> {
    List<Business> selectAll();

    List<Business> listBusiness();
    List<Business> listBusinessById(Long id);
    void deleteBusinessById(Long id);
}
