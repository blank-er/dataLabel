package com.LewisCloud.service.auth;

import com.LewisCloud.common.constant.Constants;
import com.LewisCloud.common.exception.BaseException;
import com.LewisCloud.pojo.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Service
public class TokenService {
    //令牌标识
    @Value("${token.header}")
    private String header;
    //令牌秘钥
    @Value("${token.secret}")
    private String secret;
    //令牌有效期
    @Value("${token.expireTime}")
    private int expireTime;


    @Autowired
    private UserService userService;

    //获取用户信息
    public User getLoginUser(HttpServletRequest request) {
        String token = this.getToken(request);
        try {
            return userService.findUserById(JWT.decode(token).getClaim("id").asInt());
        }catch (Exception e) {
            throw new BaseException("token", Constants.FAIL, null, "token无效或未找到信息");
        }

    }

    // 验证token
    public void verify(HttpServletRequest request) {
        try {
            //JWT验证对象
             JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(secret))
                    .build();
            jwtVerifier.verify(this.getToken(request));
        } catch (JWTVerificationException e) {
            throw new BaseException("token", Constants.FAIL, null, "token验证失败");
        }
    }

    //创建令牌
    public String createToken(User user) {
        System.out.println(secret);
        return JWT.create()
                        .withExpiresAt(new Date(System.currentTimeMillis()+expireTime))
                        .withClaim("id", user.getId())
                        .withClaim("username", user.getUsername())
                        .withClaim("identity", user.getIdentity())
                        .withClaim("emailAddress", user.getEmailAddress())
                        .withClaim("phoneNumber", user.getPhoneNumber())
                        .sign(Algorithm.HMAC256(secret));
    }

    //获得token
    public String getToken(HttpServletRequest request) {
        String token = request.getHeader(header);
        if (token != null && token.startsWith(Constants.TOKEN_PREFIX))
        {
            token = token.replace(Constants.TOKEN_PREFIX, "");
        }else throw new BaseException("token", Constants.FAIL, null, "无token");
        return token;
    }


}
