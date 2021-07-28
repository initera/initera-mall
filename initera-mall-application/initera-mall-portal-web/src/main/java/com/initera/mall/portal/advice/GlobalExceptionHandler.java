package com.initera.mall.portal.advice;

import com.initera.mall.common.exceptions.TokenException;
import com.initera.mall.common.results.ResultWrapper;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author youngmate
 * @date 2021/7/26 0:10
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    public ResultWrapper customException() {
        return ResultWrapper.builder().code(301).msg("被除数为0异常").build();
    }

    @ExceptionHandler(TokenException.class)
    public ResultWrapper authException(Exception e) {
        return ResultWrapper.builder().code(505).msg(e.getMessage()).build();
    }
}
