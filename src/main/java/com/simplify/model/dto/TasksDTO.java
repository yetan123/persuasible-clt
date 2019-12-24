package com.simplify.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TasksDTO {
    private String name;
    private Long customer;
    private String content;
    private Date date1;
    private Date date2;
    private String participant;
}
