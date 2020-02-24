package com.better.cloud.server.gen.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lius
 * @description
 * @date 2020/2/23
 */
@RestController
public class TestController {
    @GetMapping("test")
    public String test(){
        return "test";
    }
}
