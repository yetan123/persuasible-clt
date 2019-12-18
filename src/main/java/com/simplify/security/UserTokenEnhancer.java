package com.simplify.security;

import com.simplify.model.entity.User;
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
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        final Map<String, Object> additionalInfo = new HashMap<>();
        User user = (User) oAuth2Authentication.getUserAuthentication().getPrincipal();
        additionalInfo.put("username", user.getUsername());
        additionalInfo.put("account",user.getAccount());
        additionalInfo.put("gender",user.getGenders());
        additionalInfo.put("phone",user.getPhone());
        additionalInfo.put("job",user.getJob());
        additionalInfo.put("userState",user.getUserState());

        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(additionalInfo);
        return oAuth2AccessToken;
    }
}
