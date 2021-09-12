package com.LewisCloud.interceptor;

import com.LewisCloud.common.UserThreadLocal;
import com.LewisCloud.common.constant.Constants;
import com.LewisCloud.common.exception.BaseException;
import com.LewisCloud.common.utils.ServletUtils;
import com.LewisCloud.pojo.User;
import com.LewisCloud.service.auth.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component("authenticator")
public class Authenticator {

    @Autowired
    private TokenService tokenService;

    public void authenticate(String token) {
        HttpServletRequest request = ServletUtils.getRequest();
        System.out.println(tokenService);
//        try {
//            System.out.println(request.getHeader("token"));
            tokenService.getLoginUser(request);
//            UserThreadLocal.set(user);
//        }catch (Exception e) {
//            throw new BaseException("token", Constants.FAIL, null, "token验证失败");
        }
    }
//}
