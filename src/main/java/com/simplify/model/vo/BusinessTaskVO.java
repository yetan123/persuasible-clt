package com.simplify.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

/**
 * 商机任务视图对象
 * @author yuntian
 * @date 2020-1-3
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessTaskVO {
    private String id;

    private String taskContent;

    private List<Date> taskTime;

    private String taskState;

    private List<PrincipalBusinessTaskVO> participants;
}
