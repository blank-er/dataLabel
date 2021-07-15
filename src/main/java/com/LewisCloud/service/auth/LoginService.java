package com.LewisCloud.service.auth;
import com.LewisCloud.common.exception.UserException;
import com.LewisCloud.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    UserService userService;

    @Autowired
    TokenService tokenService;

    public String login(String username, String password) {
        User user = userService.loginUser(username, password);
        if (user == null) {
            throw new UserException("用户名密码不匹配");
        }
        return tokenService.createToken(user);
    }
}
