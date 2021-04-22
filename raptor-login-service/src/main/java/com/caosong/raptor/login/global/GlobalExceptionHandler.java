package com.caosong.raptor.login.global;

import com.caosong.raptor.common.utils.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result exceptionHandler(Exception e){
        logger.error(e.getMessage());
        return Result.error("系统异常，请稍后再试。");
    }

}
