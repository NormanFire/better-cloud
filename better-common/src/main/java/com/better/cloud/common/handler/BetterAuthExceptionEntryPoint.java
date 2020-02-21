package com.better.cloud.common.handler;

import com.alibaba.fastjson.JSONObject;
import com.better.cloud.common.entity.BetterResponse;
import com.better.cloud.common.utils.BetterUtil;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lius
 * @description
 * @date 2020/2/21
 */
public class BetterAuthExceptionEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        BetterResponse betterResponse = new BetterResponse();

        BetterUtil.makeResponse(
                response, MediaType.APPLICATION_JSON_UTF8_VALUE,
                HttpServletResponse.SC_UNAUTHORIZED, betterResponse.message("token无效")
        );
    }
}

