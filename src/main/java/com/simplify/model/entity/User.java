package com.simplify.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Collection;

/**
 * 用户表实体类
 * @author biaoerzi
 * @date 2019-11-30
 */
@Table(name="tb_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private Long id;

    private String account;

    private String username;

    private String password;

    private String genders;

    private String phone;

    private String job;

    private Long deptId;

    private Integer userState;


}
