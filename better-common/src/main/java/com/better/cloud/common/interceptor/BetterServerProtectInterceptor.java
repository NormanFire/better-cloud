package com.better.cloud.common.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.better.cloud.common.constant.BetterConstant;
import com.better.cloud.common.entity.BetterResponse;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.util.Base64Utils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lius
 * @description 拦截所有Web请求 校验Zuul Token
 * @date 2020/2/21
 */
public class BetterServerProtectInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        // 从请求头中获取 Zuul Token
        String token = request.getHeader(BetterConstant.ZUUL_TOKEN_HEADER);
        String zuulToken = new String(Base64Utils.encode(BetterConstant.ZUUL_TOKEN_VALUE.getBytes()));
        // 校验 Zuul Token的正确性
        if (StringUtils.equals(zuulToken, token)) {
            return true;
        } else {
            Gson gson = new Gson();
            BetterResponse betterResponse = new BetterResponse();
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write(gson.toJson(betterResponse.message("请通过网关获取资源")));
            return false;
        }
    }
}


