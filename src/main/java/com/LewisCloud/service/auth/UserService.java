package com.LewisCloud.service.auth;

import com.LewisCloud.common.core.domain.model.RegisterUser;
import com.LewisCloud.pojo.User;

public interface UserService {
    User loginUser(String username, String password);
    void registerUser(RegisterUser registerUser);
    User findUserById(int id);
    User findUserByName(String username);

}
