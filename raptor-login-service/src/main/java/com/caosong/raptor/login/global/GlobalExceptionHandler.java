package com.caosong.raptor.login.global;

import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author caosong
 * @Description 全局异常捕获器
 * @Date 2021/4/9 16:56
 **/
@ControllerAdvice
@Order(10000)
public class GlobalExceptionHandler {
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public String exceptionHandler(Exception e){
        System.out.println("未知异常！原因是:"+e);
        return "123";
    }

}
