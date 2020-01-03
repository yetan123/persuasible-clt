package com.simplify.mapper;

import com.simplify.model.dto.ChartDateDTO;
import com.simplify.model.vo.ChartVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 图表
 * @author yuntian
 * @date 2010-1-1
 */
@Repository
public interface ChartMapper {
    ChartVO countChart();

    List<ChartDateDTO> countChartGroupByDay();
}
