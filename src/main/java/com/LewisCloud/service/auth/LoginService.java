package com.LewisCloud.service.auth;
import com.LewisCloud.common.UserThreadLocal;
import com.LewisCloud.common.exception.UserException;
import com.LewisCloud.pojo.User;
import com.LewisCloud.service.UserService;
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
            throw new UserException("用户名或密码错误");
        }else {
//            UserThreadLocal.set(user);
//            System.out.println(UserThreadLocal.get());
        }
        return tokenService.createToken(user);
    }
}
