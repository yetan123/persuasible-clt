package com.simplify.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 角色菜单数据传输对象
 * @author yuntian
 * @date 2019-12-26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleOfMenuDTO {
    private Long id;

    private Long roleId;

    private Long menuId;

    private List<Long> menuIds;
}
