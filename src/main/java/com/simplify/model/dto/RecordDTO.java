package com.simplify.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecordDTO {
    private Long id;
    private String recordContent;
    private Long customer;
    private String type;
    private String desc;
    private Date date1;
    private Date date2;
    private String process;
}
