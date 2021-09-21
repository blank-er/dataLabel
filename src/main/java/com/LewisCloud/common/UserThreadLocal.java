package com.LewisCloud.common;

import com.LewisCloud.pojo.User;

public class UserThreadLocal {

    private UserThreadLocal() {

    }

    private static final ThreadLocal<User> userThreadLocal = new ThreadLocal<>();

    public static void set(User user) {
        userThreadLocal.set(user);
    }

    public static User get() {
       return userThreadLocal.get();
    }

    public static void remove() {
        userThreadLocal.remove();
    }
}
