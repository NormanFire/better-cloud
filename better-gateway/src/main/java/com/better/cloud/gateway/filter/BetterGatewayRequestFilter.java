package com.better.cloud.gateway.filter;

import com.better.cloud.common.constant.BetterConstant;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lius
 * @description 微服务保护过滤器 防止直接访问微服务
 * @date 2020/2/21
 */
@Slf4j
@Component
public class BetterGatewayRequestFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 6;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        String serviceId = (String) ctx.get(FilterConstants.SERVICE_ID_KEY);
        HttpServletRequest request = ctx.getRequest();
        String host = request.getRemoteHost();
        String method = request.getMethod();
        String uri = request.getRequestURI();

        log.info("请求URI：{}，HTTP Method：{}，请求IP：{}，ServerId：{}", uri, method, host, serviceId);

        byte[] token = Base64Utils.encode((BetterConstant.ZUUL_TOKEN_VALUE).getBytes());
        ctx.addZuulRequestHeader(BetterConstant.ZUUL_TOKEN_HEADER, new String(token));
        return null;
    }
}

