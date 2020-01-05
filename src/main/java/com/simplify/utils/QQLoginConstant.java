package com.simplify.utils;

/**
 * QQ登录常量定义
 * @author yuntian
 * @date 2020-1-4
 */
public class QQLoginConstant {
    public static final String CLIENT_ID = "101840891";

    public static final String CLIENT_SECRET = "420fad430cea31eb8926e372c041d697";

    public static final String REDIRECT_URI = "http://127.0.0.1:9624/oauth/qq";

    public static final Integer SUCCESS = 2000;

    public static final Integer HAS_BEEN_TIED = 3000;

    public static final Integer ACCOUNT_NOT_FOUND = 4004;

    public static final Integer AUTHORIZATION_ERROR = 4000;

    public static final String TOKEN_URL = "https://graph.qq.com/oauth2.0/token?grant_type=authorization_code&client_id="
            +CLIENT_ID+"&client_secret="+CLIENT_SECRET+"&code=CODE&redirect_uri="+REDIRECT_URI;

    public static final String OPEN_ID_URL = "https://graph.qq.com/oauth2.0/me?access_token=TOKEN";

    public static final String GET_USER_INFO_URL = "https://graph.qq.com/user/get_user_info?"
            + "access_token=TOKEN&"
            + "oauth_consumer_key=" + CLIENT_ID
            + "&openid=OPENID";
}
