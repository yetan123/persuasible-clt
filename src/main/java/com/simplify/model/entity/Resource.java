package com.simplify.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 资源实体类
 * @author yuntian
 * @date 2019-12-9
 */
@Table(name = "tb_resource")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resource {
    @Id
    private Long id;

    private String resourceName;

    private String url;

    private String resourceCode;
}
