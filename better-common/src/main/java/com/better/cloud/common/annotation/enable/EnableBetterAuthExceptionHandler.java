package com.better.cloud.common.annotation.enable;

import com.better.cloud.common.configure.BetterAuthExceptionConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author lius
 * @description
 * @date 2020/2/21
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(BetterAuthExceptionConfigure.class)
public @interface EnableBetterAuthExceptionHandler {

}
