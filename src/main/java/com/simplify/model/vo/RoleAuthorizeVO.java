package com.simplify.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

/**
 * @author yuntian
 * @date 2019-12-23
 * 角色权限视图对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleAuthorizeVO {
    private String roleId;

    private String roleName;

    private String roleDescribe;

    private Date createTime;

    private List<Long> menus;

    private List<Long> sources;
}
