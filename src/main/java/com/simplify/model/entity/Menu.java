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

    private String name;

    private String path;

    private Long parentId;

    private Integer hidden;

    private String title;

    private String component;

    private String icon;

    private Integer sort;

    private String permission;
}
