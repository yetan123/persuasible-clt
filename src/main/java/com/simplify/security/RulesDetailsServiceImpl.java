package com.simplify.security;

import com.simplify.model.entity.User;
import com.simplify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 自定义校验账号密码规则
 * @author yuntian
 * @date 2019-12-1
 */
@Service
public class RulesDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userServiceImpl;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userServiceImpl.findUserByUserName(s);
        if(Objects.isNull(user)){
            throw new UsernameNotFoundException(String.format("%s.这个用户不存在", s));
        }
        RulesDetails rulesDetails = new RulesDetails(user.getId(),user.getAccount()
                ,user.getUsername(),user.getPassword(),user.getGender()
                ,user.getPhone(),user.getJob(),user.getDeptId(),user.getUserState());
        return rulesDetails;
    }
}
