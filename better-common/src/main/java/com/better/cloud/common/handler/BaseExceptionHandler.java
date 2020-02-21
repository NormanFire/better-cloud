package com.better.cloud.common.handler;

import com.better.cloud.common.entity.BetterResponse;
import com.better.cloud.common.exception.BetterAuthException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author lius
 * @description 全局异常处理
 * @date 2020/2/21
 */
@Slf4j
public class BaseExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BetterResponse handleException(Exception e) {
        log.error("系统内部异常，异常信息", e);
        return new BetterResponse().message("系统内部异常");
    }

    @ExceptionHandler(value = BetterAuthException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BetterResponse handleBetterAuthException(BetterAuthException e) {
        log.error("系统错误", e);
        return new BetterResponse().message(e.getMessage());
    }

    @ExceptionHandler(value = AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public BetterResponse handleAccessDeniedException(){
        return new BetterResponse().message("没有权限访问该资源");
    }
}

