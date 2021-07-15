package com.LewisCloud.service.auth;

import com.LewisCloud.common.core.domain.model.RegisterUser;
import com.LewisCloud.mapper.UserMapper;
import com.LewisCloud.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.LewisCloud.common.utils.MD5Utils;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User loginUser(String username,String password){
        return userMapper.getUser(username,MD5Utils.getMD5(password));
    }

    @Transactional
    public void registerUser(RegisterUser registerUser){
        System.out.println(registerUser);
        userMapper.setUser(registerUser);
        registerUser.setPassword(MD5Utils.getMD5(registerUser.getPassword()));
        userMapper.setLocalAuth(registerUser);
    }

    public User findUserById(int id){
        return userMapper.getUserById(id);
    }

    public User findUserByName(String username)  {
        return userMapper.getUserByName(username);
    }



}
