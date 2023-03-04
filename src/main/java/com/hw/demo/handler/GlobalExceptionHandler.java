package com.hw.demo.handler;

import cn.dev33.satoken.exception.NotLoginException;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONWriter;
import com.hw.demo.common.Result;
import com.hw.demo.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        log.error(e.getMessage(), e.getCause());
        return JSON.toJSONString(Result.fail(e.getMessage()), JSONWriter.Feature.WriteNulls);
    }

    @ExceptionHandler(BusinessException.class)
    public String handleBusinessException(BusinessException e) {
        log.error(e.getMessage(), e.getCause());
        return JSON.toJSONString(Result.fail(e.getCode(), e.getMessage(), null), JSONWriter.Feature.WriteNulls);
    }

    @ExceptionHandler(NotLoginException.class)
    public String handleNotLoginException(NotLoginException e) {
        log.error(e.getLocalizedMessage(), e.getCause());
        return switch (e.getType()) {
            case "-3" -> JSON.toJSONString(Result.fail("当前登录已过期，请重新登录"), JSONWriter.Feature.WriteNulls);
            case "-4" -> JSON.toJSONString(Result.fail("您已在其他地方登录"), JSONWriter.Feature.WriteNulls);
            case "-5" -> JSON.toJSONString(Result.fail("您已被强制下线"), JSONWriter.Feature.WriteNulls);
            default -> JSON.toJSONString(Result.fail("Token错误或尚未登录，无法操作"), JSONWriter.Feature.WriteNulls);
        };
    }
}
