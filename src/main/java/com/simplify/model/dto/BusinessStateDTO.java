package com.simplify.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 商机状态数据更改信息传输对象
 * @author yuntian
 * @date 2020-1-3
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessStateDTO {
    private Long id;

    private Integer businessState;
}
