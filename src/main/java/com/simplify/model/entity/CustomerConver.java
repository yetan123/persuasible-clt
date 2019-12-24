package com.simplify.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import java.util.Date;

@Table(name="TB_CUSTOMER_CONVER")
@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * 客户转交
 * @date 2019/12/20
 * @author lanmu
 */
public class CustomerConver {
    private Long id;
    private Long converUserId;
    private Long receiveUserId;
    private Long customerId;
    private Date converTime;

}
