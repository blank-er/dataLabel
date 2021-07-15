package com.LewisCloud.interceptor;

import com.LewisCloud.common.constant.Constants;
import com.LewisCloud.common.exception.BaseException;
import com.LewisCloud.common.utils.ServletUtils;
import com.LewisCloud.service.auth.TokenService;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseAuthenticator implements Authenticator{

    @Autowired
    private TokenService tokenService;

    public void authenticate(String token) {
        try {
            tokenService.getLoginUser(ServletUtils.getRequest());
        }catch (Exception e) {
            throw new BaseException("token", Constants.FAIL, null, "token验证失败");
        }
    }
}
