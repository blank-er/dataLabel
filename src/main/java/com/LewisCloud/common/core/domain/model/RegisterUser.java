package com.LewisCloud.common.core.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//注册映射视图
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUser {
    private int id;
    private String username;
    private String identity;
    private String emailAddress;
    private String phoneNumber;
    private String password;
}
