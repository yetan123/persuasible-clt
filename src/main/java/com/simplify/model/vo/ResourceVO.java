package com.simplify.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 资源视图对象
 * @author yuntian
 * @date 2019-12-25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceVO {
    private Long id;

    private String resourceName;
}
