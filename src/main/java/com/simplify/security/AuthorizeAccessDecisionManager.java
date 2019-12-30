package com.simplify.security;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Objects;

/**
 * 权限控制
 */
@Service
public class AuthorizeAccessDecisionManager implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        if(Objects.isNull(configAttributes) || configAttributes.size() <=0) {
            return;
        }
        configAttributes.forEach((configAttribute)->{
            String needRole = configAttribute.getAttribute();
            authentication.getAuthorities().forEach((authorities)->{
                if(needRole.trim().equals(authorities.toString())){
                    return;
                }
            });

        });
        throw new AccessDeniedException("权限不足");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
