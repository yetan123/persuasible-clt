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

<<<<<<< HEAD
=======
    List<Business> listBusiness();
    List<Business> listBusinessById(Long id);
>>>>>>> 1fd99a8d51a7bf1d721da8a3be96aef04100591d
}
