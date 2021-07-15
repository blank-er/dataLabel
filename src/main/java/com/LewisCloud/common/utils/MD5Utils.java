package com.LewisCloud.common.utils;

import org.springframework.util.DigestUtils;

public class MD5Utils {
    //盐
    private static final String salt = "*$^F*#@!#86(%$#%*^^*$%";

    public static String getMD5(String str) {
        String base = str + "/" + salt;
        return DigestUtils.md5DigestAsHex(base.getBytes());
    }
}
