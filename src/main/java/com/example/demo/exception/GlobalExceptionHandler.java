package com.example.demo.exception;

import com.example.demo.entity.Result;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;


@ControllerAdvice
public class GlobalExceptionHandler {

    private final static String EXCEPTION_MSG_KEY = "Exception message : ";

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleValidException(MethodArgumentNotValidException e){
        //日志记录错误信息
        //将错误信息返回给前台
        return Result.error(103, Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage());
    }
}