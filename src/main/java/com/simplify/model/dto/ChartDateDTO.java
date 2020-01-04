package com.simplify.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 图表根据日期统计封装类
 * @author yuntian
 * @date 2020-1-1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChartDateDTO {
    private Integer day;

    private Integer count;
}
