package com.better.cloud.auth.controller;

import com.better.cloud.auth.service.ValidateCodeService;
import com.better.cloud.common.entity.BetterResponse;
import com.better.cloud.common.exception.BetterAuthException;
import com.better.cloud.common.exception.ValidateCodeException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

/**
 * @author lius
 * @description
 * @date 2020/2/20
 */
@RestController
public class SecurityController {

    @Autowired
    private ConsumerTokenServices consumerTokenServices;

    @Autowired
    private ValidateCodeService validateCodeService;

    @GetMapping("captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException, ValidateCodeException {
        validateCodeService.create(request, response);
    }

    @GetMapping("oauth/test")
    public String testOauth() {
        return "oauth";
    }

    @GetMapping("user")
    public Principal currentUser(Principal principal) {
        return principal;
    }

    @DeleteMapping("signout")
    public BetterResponse signout(HttpServletRequest request) throws BetterAuthException {
        String authorization = request.getHeader("Authorization");
        String token = StringUtils.replace(authorization, "bearer ", "");
        BetterResponse betterResponse = new BetterResponse();
        if (!consumerTokenServices.revokeToken(token)) {
            throw new BetterAuthException("退出登录失败");
        }
        return betterResponse.message("退出登录成功");
    }
}
