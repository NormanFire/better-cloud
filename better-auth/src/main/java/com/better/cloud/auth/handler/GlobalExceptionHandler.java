package com.better.cloud.auth.handler;

import com.better.cloud.common.handler.BaseExceptionHandler;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author lius
 * @description 微服务自定义异常处理
 * @date 2020/2/21
 */
@RestControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE) //处于最高优先级
public class GlobalExceptionHandler extends BaseExceptionHandler {
}
