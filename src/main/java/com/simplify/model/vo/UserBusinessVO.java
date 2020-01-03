package com.simplify.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 商机绑定用户时相关视图对象
 * @author yuntian
 * @date 2020-1-2
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBusinessVO {
    private String id;

    private String username;
}
