package com.LewisCloud.mapper;

import com.LewisCloud.common.core.domain.model.RegisterUser;
import com.LewisCloud.pojo.LocalAuth;
import com.LewisCloud.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;

public interface UserMapper {
    User getUser(@Param("username")String username, @Param("password")String password);
    User getUserByName(@Param("username")String username);
    User getUserById(@Param("id")int id);

    void setUser(@Param("registerUser")RegisterUser registerUser);
    void setLocalAuth(@Param("registerUser")RegisterUser registerUser);

    void deleteUser(@Param("id")int id);

}
