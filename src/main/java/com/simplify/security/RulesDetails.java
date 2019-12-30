package com.simplify.security;

import com.simplify.model.entity.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

/**
 * 验证规则详细类
 * @author yuntian
 * @date 2019-12-5
 */
@Data
public class RulesDetails extends User implements UserDetails {
    private Set<GrantedAuthority> grantedAuthoritySet;
    public RulesDetails(Long id, String account, String username, String password, String genders, String phone, String job
            , Long deptId, Integer userState, Set<GrantedAuthority> grantedAuthoritySet) {
        this.setId(id);
        this.setAccount(account);
        this.setUsername(username);
        this.setPassword(password);
        this.setGenders(genders);
        this.setPhone(phone);
        this.setJob(job);
        this.setDeptId(deptId);
        this.setUserState(userState);
        this.setGrantedAuthoritySet(grantedAuthoritySet);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.getGrantedAuthoritySet();
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
        return this.getUserState() == 1;
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
