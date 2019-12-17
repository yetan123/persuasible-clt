package com.simplify.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 菜单资源类
 * @author yuntian
 * @date 2019-12-9
 */
@Table(name = "tb_menu")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    @Id
    private Long id;

    private String menuName;

    private Integer requireAuth;

    private String path;

    private String routeUrl;

    private Long parentId;

    private Integer menuState;

    private String component;
}
