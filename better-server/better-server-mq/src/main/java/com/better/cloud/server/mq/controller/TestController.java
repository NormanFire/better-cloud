package com.better.cloud.server.mq.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Mou Yiquan
 * @create: 2020/3/8 11:20
 * @description: Test Controller
 **/
@RestController
@RequestMapping("/test")
@Scope(value = "singleton") //默认单例，多例请修改为prototype
public class TestController {
}
