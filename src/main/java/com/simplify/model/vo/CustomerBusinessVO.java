package com.simplify.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 商机客户相关信息视图对象
 * @author yuntian
 * @date 2020-1-2
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerBusinessVO {
    private String id;

    private String companyName;
}
