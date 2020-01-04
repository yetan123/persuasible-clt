package com.simplify.mapper;


import com.simplify.model.dto.BusinessDTO;
import com.simplify.model.dto.BusinessInfoDTO;
import com.simplify.model.dto.BusinessVO;
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
    List<BusinessVO> listBusiness();
    List<BusinessVO> listBusinessById(Long id);


    void deleteBusinessById(Long id);
    int insertBusiness(BusinessInfoDTO businessInfoDTO);
    int updateBusiness(BusinessInfoDTO businessInfoDTO);

}
