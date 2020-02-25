package com.better.cloud.server.gen.aspect;

import com.better.cloud.common.constant.GeneratorConstant;
import com.better.cloud.server.gen.datasource.DataSource;
import com.better.cloud.server.gen.datasource.DataSourceHolder;
import com.better.cloud.server.gen.datasource.DynamicDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author lius
 * @description
 * @date 2020/2/24
 */
@Slf4j
@Aspect
@Component
public class DataSourceAspect implements Ordered {

    @Pointcut("@annotation(com.better.cloud.server.gen.datasource.DataSource)")
    public void dataSourcePointCut() {

    }

    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();

        DataSource dataSource = method.getAnnotation(DataSource.class);
        if (ObjectUtils.isNotEmpty(dataSource)) {
            DataSourceHolder.setDataSource(GeneratorConstant.BASE_DATASOURCE);
            log.info("set datasource -> {} " , GeneratorConstant.BASE_DATASOURCE);
        }

        try {
            return point.proceed();
        } finally {
            DataSourceHolder.clearDataSource();
            log.info("clean datasource");
        }
    }

    @Override
    public int getOrder() {
        return 1;
    }

}
