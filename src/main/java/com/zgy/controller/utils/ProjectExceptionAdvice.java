package com.zgy.controller.utils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 作为SpringMVC的异常处理器
// @ControllerAdvice
@RestControllerAdvice
public class ProjectExceptionAdvice {
    // 拦截所有的异常信息
    @ExceptionHandler
    public Result doException(Exception ex){
        ex.printStackTrace();
        return new Result("服务器故障，请稍后再试！");
    }
}
