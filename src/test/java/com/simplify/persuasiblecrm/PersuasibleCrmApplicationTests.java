package com.simplify.persuasiblecrm;



import com.simplify.mapper.ChartMapper;
import com.simplify.model.dto.ChartDateDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.*;


@SpringBootTest
class PersuasibleCrmApplicationTests {
    @Autowired
    private ChartMapper chartMapper;
    @Test
    void contextLoads() {
        List<ChartDateDTO> chartDateDTOS = chartMapper.countChartGroupByDay();
        Map<Integer,Integer> dateMap = new HashMap<>();
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(Calendar.MONTH,gregorianCalendar.get(Calendar.MONTH)-1);
        for(int day = 1;day<=gregorianCalendar.get(Calendar.DATE);day++){
            dateMap.put(day,0);
            gregorianCalendar.set(Calendar.DATE,gregorianCalendar.get(Calendar.DATE)+1);
        }
        chartDateDTOS.forEach(chartDate-> dateMap.put(chartDate.getDay(),chartDate.getCount()));
        System.out.println(dateMap);
    }

}
