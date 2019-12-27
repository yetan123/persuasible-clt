package com.simplify.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAndParmeterPageDTO {
    private String deptName;
    private String userSearch;
    private Integer pageNum;
}
