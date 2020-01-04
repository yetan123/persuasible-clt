package com.simplify.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 商机任务负责人数据传输对象
 * @author yuntian
 * @date 2020-1-4
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessTaskPrincipalDTO {
    private Long taskId;

    private List<Long> userIds;
}
