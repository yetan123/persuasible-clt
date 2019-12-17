package com.simplify.security;

import com.simplify.model.entity.User;
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

    public RulesDetails(Long id, String account, String username, String password, String gender, String phone, String job, Long deptId, Integer userState) {
        this.setId(id);
        this.setAccount(account);
        this.setUsername(username);
        this.setPassword(password);
        this.setGender(gender);
        this.setPhone(phone);
        this.setJob(job);
        this.setDeptId(deptId);
        this.setUserState(userState);
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
        return super.getUsername();
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
