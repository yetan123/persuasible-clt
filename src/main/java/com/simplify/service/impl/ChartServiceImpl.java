package com.simplify.service.impl;

import com.simplify.mapper.ChartMapper;
import com.simplify.model.dto.ChartDateDTO;
import com.simplify.model.vo.ChartVO;
import com.simplify.service.ChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 图表业务实现类
 * @author yuntian
 * @date 2020-1-1
 */
@Service
public class ChartServiceImpl implements ChartService {
    @Autowired
    private ChartMapper chartMapper;
    @Override
    public ChartVO findChart() {
        return chartMapper.countChart();
    }

    @Override
    public Map<Integer,Integer> countChartGroupByDay() {
        List<ChartDateDTO> chartDateDTOS = chartMapper.countChartGroupByDay();
        Map<Integer,Integer> dateMap = new HashMap<>();
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(Calendar.MONTH,gregorianCalendar.get(Calendar.MONTH)-1);
        for(int day = 1;day<=gregorianCalendar.get(Calendar.DATE);day++){
            dateMap.put(day,0);
            gregorianCalendar.set(Calendar.DATE,gregorianCalendar.get(Calendar.DATE)+1);
        }
        chartDateDTOS.forEach((chartDate)->{
            dateMap.put(chartDate.getDay(),chartDate.getCount());
        });
        return dateMap;
    }
}
