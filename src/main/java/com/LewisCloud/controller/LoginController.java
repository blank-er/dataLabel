package com.LewisCloud.controller;

import com.LewisCloud.common.constant.Constants;
import com.LewisCloud.common.core.domain.AjaxResult;
import com.LewisCloud.common.core.domain.model.LoginBody;
import com.LewisCloud.common.core.domain.model.RegisterUser;
import com.LewisCloud.common.exception.BaseException;
import com.LewisCloud.service.auth.LoginService;
import com.LewisCloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;


@RestController
public class LoginController {
    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Autowired
    private LoginService loginService;


    @PostMapping("/register")
    public AjaxResult register(@RequestBody RegisterUser registerUser) {
        if (registerUser == null) {
            throw new BaseException("无参数");
        } else if (registerUser.getUsername() == null || registerUser.getPassword() == null) {
            throw new BaseException("用户名或密码为空");
        } else if (registerUser.getIdentity() == null) {
            throw new BaseException("身份信息为空");
        } else {
            if (userService.findUserByName(registerUser.getUsername()) != null) {
                throw new BaseException("用户名已存在");
            }
            System.out.println(registerUser);
            userService.registerUser(registerUser);
            return AjaxResult.success();
        }
    }

    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginBody loginBody) {
        System.out.println(loginBody);
        if (loginBody == null) {
            throw new BaseException("无参数");
        } else if (loginBody.getUsername() == null || loginBody.getPassword() == null) {
            throw new BaseException("用户名或密码为空");
        }
        AjaxResult ajax = AjaxResult.success();
        // 生成令牌
        String token = loginService.login(loginBody.getUsername(), loginBody.getPassword());
        ajax.put(Constants.TOKEN, token);
        return ajax;
    }

}
