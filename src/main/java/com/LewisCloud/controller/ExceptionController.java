package com.LewisCloud.controller;

import com.LewisCloud.common.core.domain.AjaxResult;
import com.LewisCloud.common.exception.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionController {

    private static Logger logger = LoggerFactory.getLogger(ExceptionController.class);

    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public AjaxResult handleException(Exception e) {
        logger.error(e.getMessage(), e);
//        return AjaxResult.error(Constants.FAIL, e.getMessage());
        return AjaxResult.error(e.getMessage(), e);
    }
}
