package com.LewisCloud.common.exception;

import com.LewisCloud.common.constant.Constants;

public class UserException extends BaseException{
    public UserException(String code, Object[] args, String defaultMessage) {
        super("user", code, args, defaultMessage);
    }

    public UserException(String defaultMessage) {
        super("user", Constants.FAIL, null, defaultMessage);
    }
}
