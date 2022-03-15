package com.LewisCloud.common.exception;

import com.LewisCloud.common.constant.Constants;
import org.springframework.util.StringUtils;
import sun.misc.MessageUtils;

public class BaseException extends RuntimeException{
    //所属模块
    private final String module;
    //错误码
    private final String code;
    //错误码对应参数
    private final Object[] args;
    //错误信息
    private final String defaultMessage;

    public BaseException(String module, String code, Object[] args, String defaultMessage)
    {
        this.module = module;
        this.code = code;
        this.args = args;
        this.defaultMessage = defaultMessage;
    }


    public BaseException(String module, String code, Object[] args)
    {
        this(module, code, args, null);
    }

    public BaseException(String module, String defaultMessage)
    {
        this(module, null, null, defaultMessage);
    }

    public BaseException(String code, Object[] args)
    {
        this(null, code, args, null);
    }

    public BaseException(String defaultMessage)
    {
        this(null, Constants.FAIL, null, defaultMessage);
    }

    public String getMessage() {
        return defaultMessage;
    }

    public String getModule() {
        return module;
    }

    public String getCode() {
        return code;
    }

    public Object[] getArgs() {
        return args;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }

}
