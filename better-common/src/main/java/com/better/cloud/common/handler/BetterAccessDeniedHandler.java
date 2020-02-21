package com.better.cloud.common.handler;

import com.better.cloud.common.entity.BetterResponse;
import com.better.cloud.common.utils.BetterUtil;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lius
 * @description
 * @date 2020/2/21
 */
public class BetterAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        BetterResponse betterResponse = new BetterResponse();
        BetterUtil.makeResponse(
                response, MediaType.APPLICATION_JSON_UTF8_VALUE,
                HttpServletResponse.SC_FORBIDDEN, betterResponse.message("没有权限访问该资源"));
    }
}

