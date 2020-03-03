package com.better.cloud.server.wiki.aspect;

import com.better.cloud.common.annotation.ControllerEndpoint;
import com.better.cloud.common.exception.BetterException;
import com.better.cloud.common.utils.BetterUtil;
import com.better.cloud.server.wiki.service.ILogService;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @author MrBird
 */
@Aspect
@Component
public class ControllerEndpointAspect extends AspectSupport {

    @Autowired
    private ILogService logService;

    @Pointcut("@annotation(com.better.cloud.common.annotation.ControllerEndpoint)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws BetterException {
        Object result;
        Method targetMethod = resolveMethod(point);
        ControllerEndpoint annotation = targetMethod.getAnnotation(ControllerEndpoint.class);
        String operation = annotation.operation();
        long start = System.currentTimeMillis();
        try {
            result = point.proceed();
            if (StringUtils.isNotBlank(operation)) {
                String username = BetterUtil.getCurrentUsername();
                String ip = BetterUtil.getHttpServletRequestIpAddress();
                HttpServletRequest request = BetterUtil.getHttpServletRequest();
                String method = request.getMethod();
                
//                logService.saveLog(point, targetMethod, ip, operation, username, start);
            }
            return result;
        } catch (Throwable throwable) {
            String exceptionMessage = annotation.exceptionMessage();
            String message = throwable.getMessage();
            String error = BetterUtil.containChinese(message) ? exceptionMessage + "，" + message : exceptionMessage;
            throw new BetterException(error);
        }
    }
}



