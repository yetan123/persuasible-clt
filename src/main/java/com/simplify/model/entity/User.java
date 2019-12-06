package com.simplify.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户表实体类
 * @author yuntian
 * @date 2019-11-30
 */
@Table(name="tb_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private Integer userId;

    private String userName;

    private String password;
}
