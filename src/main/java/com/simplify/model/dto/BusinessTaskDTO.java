package com.simplify.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.util.List;

/**
 * 商机任务数据传输对象
 * @author yuntian
 * @date 2020-1-4
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessTaskDTO {
    private String id;

    private String businessId;

    private String taskContent;

    private List<Date> taskTime;

    private List<String> participants;
}
