package com.LewisCloud.service;

import com.LewisCloud.common.core.domain.model.RegisterUser;
import com.LewisCloud.pojo.User;

public interface UserService {
    User loginUser(String username, String password);
    void registerUser(RegisterUser registerUser);
    User getUserById(int id);
    User getUserByName(String username);

}
