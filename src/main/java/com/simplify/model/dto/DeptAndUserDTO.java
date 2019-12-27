package com.simplify.model.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.Id;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeptAndUserDTO {
    @Id
    private Long id;

    private String deptName;

    private Integer enterpriseId;

    private String describe;
}
