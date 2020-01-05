package com.simplify.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 图表视图对象
 * @author yuntian
 * @date 2020-1-1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChartVO {
    private Integer consumerCount;

    private Integer clueCount;

    private Integer businessCount;

    private Integer productCount;
}
