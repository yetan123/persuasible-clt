package com.simplify.model.dto;

import com.simplify.model.entity.Menu;
import com.simplify.model.entity.Resource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 角色授权数据传输对象,封装角色拥有哪些权限
 * @author yuntian
 * @date 2019-12-18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleAuthorizeDTO {
    private Long id;

    private String role_name;

    private List<Resource> resources;

    private List<Menu> menus;
}
