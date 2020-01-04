package com.simplify.controller;

import com.simplify.model.vo.ChartVO;
import com.simplify.service.ChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 图表控制器
 * @author yuntian
 * @date 2020-1-1
 */
@RestController
@RequestMapping("chart")
public class ChartController {
    @Autowired
    private ChartService chartServiceImpl;

    @GetMapping("")
    public Map<String,Object> chartShow(){
        ChartVO chart = chartServiceImpl.findChart();
        Map<String,Object> chartMap = new HashMap<>();
        chartMap.put("countChart",chart);
        Map<Integer, Integer> integerIntegerMap = chartServiceImpl.countChartGroupByDay();
        chartMap.put("dayAndCount",integerIntegerMap);
        return chartMap;
    }
}
