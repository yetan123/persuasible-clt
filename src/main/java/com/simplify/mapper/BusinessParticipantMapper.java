package com.simplify.mapper;

import com.simplify.model.dto.BusinessTaskPrincipalDTO;
import com.simplify.model.entity.BusinessTaskPrincipal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * 商机任务负责人
 * @author yuntian
 * @date 2020-1-4
 */
@Repository
public interface BusinessParticipantMapper extends Mapper<BusinessTaskPrincipal> {
    Integer addBusinessParticipant(BusinessTaskPrincipal businessTaskPrincipal);

    Integer removeBusinessParticipant(BusinessTaskPrincipalDTO bsinessTaskPrincipalDTO);
}
