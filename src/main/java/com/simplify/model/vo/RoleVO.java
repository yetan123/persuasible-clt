package com.simplify.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 角色视图对象
 * @author yuntian
 * @date 2020-1-2
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleVO {
    private String id;

    private String roleName;
}
