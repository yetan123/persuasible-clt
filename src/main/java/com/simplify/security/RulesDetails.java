package com.simplify.security;

import com.simplify.model.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * 验证规则详细类
 * @author yuntian
 * @date 2019-12-5
 */
public class RulesDetails extends User implements UserDetails {
    public RulesDetails() {
    }

    public RulesDetails(Integer userId, String userName, String password) {
        this.setUserId(userId);
        this.setUserName(userName);
        this.setPassword(password);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
