package com.simplify.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * 封装路由相关信息
 * @author yuntian
 * @date 2019-12-19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteDTO {
    private Long id;

    private String name;

    private String path;

    private Boolean hidden;

    private String component;

    private String icon;

    private String title;

    private List<String> permission;

    private List<RouteDTO> children;
}
