package com.simplify.security;

import com.simplify.model.dto.UserAuthorizeDTO;
import com.simplify.model.entity.User;
import com.simplify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

/**
 * 为token添加额外信息内容
 */
@Configuration
public class UserTokenEnhancer implements TokenEnhancer {
    @Autowired
    private UserService UserServiceImpl;
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        final Map<String, Object> additionalInfo = new HashMap<>();
        User user = (User) oAuth2Authentication.getUserAuthentication().getPrincipal();
        UserAuthorizeDTO userAuthorizeDTO = UserServiceImpl.findUserAuthorizeById(user.getId());
        additionalInfo.put("id", userAuthorizeDTO.getId());
        additionalInfo.put("username", userAuthorizeDTO.getUsername());
        additionalInfo.put("genders", userAuthorizeDTO.getGenders());
        additionalInfo.put("phone", userAuthorizeDTO.getPhone());
        additionalInfo.put("account",userAuthorizeDTO.getAccount());
        additionalInfo.put("job",userAuthorizeDTO.getJob());
        additionalInfo.put("deptId",userAuthorizeDTO.getDeptId());
        additionalInfo.put("userState",userAuthorizeDTO.getUserState());
        additionalInfo.put("roles",userAuthorizeDTO.getRoles());

        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(additionalInfo);
        return oAuth2AccessToken;
    }
}
