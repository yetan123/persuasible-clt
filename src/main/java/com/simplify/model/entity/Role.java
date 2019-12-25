package com.simplify.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

/**
 * 角色实体类，封装了具体角色相关字段
 * @author yuntian
 * @date 2019-12-9
 */
@Table(name = "tb_role")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    private Long id;

    private String roleName;

    private String roleDescribe;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

}
