package com.simplify.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 商机中根据客户查出联系人
 * @author yuntian
 * @Date 2020-1-1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessLinkmanVO {
    private String id;

    private String customerName;
}
