package com.simplify.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 角色权限数据传输对象
 * @author yuntian
 * @date 2019-12-25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleOfResourceDTO {
    private Long id;

    private Long roleId;

    private Long resourceId;

    private List<Long> resourceIds;
}
