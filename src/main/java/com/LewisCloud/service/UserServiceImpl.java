package com.LewisCloud.service;

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

    @Override
    public User loginUser(String username,String password){
        return userMapper.getUser(username,MD5Utils.getMD5(password));
    }

    @Override
    @Transactional
    public void registerUser(RegisterUser registerUser){
        System.out.println(registerUser);
        userMapper.addUser(registerUser);
        registerUser.setPassword(MD5Utils.getMD5(registerUser.getPassword()));
        userMapper.addLocalAuth(registerUser);
    }

    @Override
    public User getUserById(int id){
        return userMapper.getUserById(id);
    }

    @Override
    public User getUserByName(String username)  {
        return userMapper.getUserByName(username);
    }



}
