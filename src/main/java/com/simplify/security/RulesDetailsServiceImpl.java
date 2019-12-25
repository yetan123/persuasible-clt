package com.simplify.security;

import com.simplify.model.entity.Resource;
import com.simplify.model.entity.User;
import com.simplify.service.ResourceService;
import com.simplify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 自定义校验账号密码规则
 * @author yuntian
 * @date 2019-12-1
 */
@Service
public class RulesDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userServiceImpl;
    @Autowired
    private ResourceService resourceServiceImpl;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userServiceImpl.findUserByAccount(s);
        if(Objects.isNull(user)){
            throw new UsernameNotFoundException(String.format("%s.这个用户不存在", s));
        }
        List<Resource> resources = resourceServiceImpl.listResourceByRoleId(user.getId());
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        resources.forEach((resource)->{
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(resource.getResourceName() + ":" + resource.getResourceCode());
            grantedAuthorities.add(grantedAuthority);
        });
        RulesDetails rulesDetails = new RulesDetails(user.getId(),user.getAccount()
                ,user.getUsername(),user.getPassword(),user.getGenders()
                ,user.getPhone(),user.getJob(),user.getDeptId(),user.getUserState(),grantedAuthorities);
        return rulesDetails;
    }
}
