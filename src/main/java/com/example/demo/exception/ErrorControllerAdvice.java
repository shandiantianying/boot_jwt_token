package com.example.demo.exception;

import com.example.demo.entity.ResultInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ErrorControllerAdvice {
    /**
     * 返回的Map对象会被@ResponseBody注解转换为JSON数据返回
     * @return
     */
//    @ExceptionHandler(Exception.class)
//    @ResponseBody
//    public Object handleException(HttpServletRequest request, Exception e){
//        System.out.println("###出现异常！");
//        return ResultInfo.error(null,e.getMessage());
//
//    }
}
