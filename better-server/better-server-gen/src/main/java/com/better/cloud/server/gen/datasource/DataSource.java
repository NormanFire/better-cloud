package com.better.cloud.server.gen.datasource;
import java.lang.annotation.*;

/**
 * @author lius
 * @description
 * @date 2020/2/24
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String name() default "master";
}
