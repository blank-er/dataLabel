package com.LewisCloud.interceptor;

public interface Authenticator {
    void authenticate(String token) throws Exception;
}
