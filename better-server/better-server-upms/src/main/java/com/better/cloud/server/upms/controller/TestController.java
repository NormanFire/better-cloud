package com.better.cloud.server.upms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author lius
 * @description
 * @date 2020/2/20
 */
@RestController
public class TestController {

    @GetMapping("info")
    public String test(){
        return "better-server-upms";
    }

    @GetMapping("currentUser")
    public Principal currentUser(Principal principal) {
        return principal;
    }

    @GetMapping("hello")
    public String hello(String name) {
        return "hello " + name;
    }
}
