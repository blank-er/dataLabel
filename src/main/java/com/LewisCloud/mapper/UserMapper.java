package com.LewisCloud.mapper;

import com.LewisCloud.common.core.domain.model.RegisterUser;
import com.LewisCloud.pojo.User;
import org.apache.ibatis.annotations.Param;


public interface UserMapper {
    User getUser(@Param("username")String username, @Param("password")String password);
    User getUserByName(@Param("username")String username);
    User getUserById(@Param("id")int id);

    void addUser(@Param("registerUser")RegisterUser registerUser);
    void addLocalAuth(@Param("registerUser")RegisterUser registerUser);

    void deleteUser(@Param("id")int id);

}
