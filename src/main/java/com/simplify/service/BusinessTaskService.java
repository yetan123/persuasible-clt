package com.simplify.service;

import com.simplify.model.dto.BusinessTaskDTO;
import com.simplify.model.vo.BusinessTaskVO;
import com.simplify.model.vo.PrincipalBusinessTaskVO;

import java.util.List;

/**
 * 商机跟进任务业务接口
 * @author yuntian
 * @date 2020-1-3
 */
public interface BusinessTaskService {
    List<BusinessTaskVO> listBusinessTask(Long businessId);

    List<PrincipalBusinessTaskVO> listPrincipalBusinessTaskVO();

    Integer addBusinessTask(BusinessTaskDTO businessTaskDTO);

    Integer deleteBusinessTask(Long id);

    Integer updateBusinessTask(BusinessTaskDTO businessTaskDTO);

    Integer changeBusinessTaskById(Long id);
}
