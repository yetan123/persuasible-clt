package com.simplify.service;

import com.simplify.model.vo.ChartVO;
import java.util.Map;

/**
 * 图表业务接口
 * @author yuntian
 * @date 2020-1-1
 */
public interface ChartService {
    ChartVO findChart();

    Map<Integer,Integer> countChartGroupByDay();
}
