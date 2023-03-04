package com.hw.demo.handler;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONWriter;
import com.hw.demo.common.Result;
import com.hw.demo.exception.BusinessException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        return JSON.toJSONString(Result.fail(e.getMessage()), JSONWriter.Feature.WriteNulls);
    }

    @ExceptionHandler(BusinessException.class)
    public String handleRuntimeException(BusinessException e) {
        return JSON.toJSONString(Result.fail(e.getCode(), e.getMessage(), null), JSONWriter.Feature.WriteNulls);
    }
}
