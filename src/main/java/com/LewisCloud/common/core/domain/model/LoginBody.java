package com.LewisCloud.common.core.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//登录映射视图
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginBody {
    private String username;
    private String password;
}
