package com.simplify.interceptor;

import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * 跨域拦截器,配置跨越头部信息
 * @author yuntian
 * @date 2019-12-5
 */
public class CorsRequestHeaderInterator implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setHeader("Access-Control-Allow-Origin","http://localhost:9527");//允许ButterflyCloud访问
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        if(Objects.equals("OPTIONS",request.getMethod())){
            response.setStatus(HttpStatus.OK.value());
            return false;
        }
        return true;
    }
}
