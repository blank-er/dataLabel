package com.LewisCloud.interceptor;


import com.LewisCloud.common.constant.Constants;
import com.LewisCloud.common.exception.UserException;
import com.LewisCloud.service.auth.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    TokenService tokenService;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {

        String token = tokenService.getToken(request);

        if (!(object instanceof HandlerMethod)) {
            return true;
        }

        // 判断有无token
        if (token == null) {
            throw new UserException("无token,请重新登录");
        }

        // 验证token
        tokenService.verify(request);

        Authenticator authenticator = new BaseAuthenticator();
        authenticator.authenticate(token);

        return true;
    }


    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object o, Exception e) throws Exception {
    }
}