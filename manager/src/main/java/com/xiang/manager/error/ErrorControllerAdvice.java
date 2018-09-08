package com.xiang.manager.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 统一错误处理
 * 此类先于CustomErrorController执行
 * 若此类出现异常则会到达CustomErrorController
 * Author：guixiang
 * Date:2018-09-06
 */
@ControllerAdvice(basePackages = {"com.xiang.manager.controller"})
public class ErrorControllerAdvice
{
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity handleException(Exception e)
    {
        Map<String,Object> attrs = new HashMap<String,Object>();
        String errorCode = (String) e.getMessage();
        ErrorEnum errorEnum = ErrorEnum.getByCode(errorCode);
        attrs.put("message",errorEnum.getMessage());
        attrs.put("code",errorEnum.getCode());
        attrs.put("canRetry",errorEnum.isCanRetry());
        return new ResponseEntity(attrs, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
