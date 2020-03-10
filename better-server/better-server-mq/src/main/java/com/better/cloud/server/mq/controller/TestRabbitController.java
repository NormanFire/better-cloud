package com.better.cloud.server.mq.controller;

import com.better.cloud.common.entity.result.Result;
import com.better.cloud.server.mq.producer.rabbit.RabbitMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Mou Yiquan
 * @create: 2020/3/8 11:19
 * @description: Test Rabbit MQ Producer And Consumer
 **/
@RestController
@RequestMapping("/rabbit")
public class TestRabbitController{

    @Autowired
    RabbitMQProducer producer;

    @RequestMapping("/direct")
    public Result<String> directSend(String msg){
        producer.send(msg);
        return Result.success("1");
    }

    @RequestMapping(value = "/topic", method = RequestMethod.POST)
    public Result<String> topicSend(String msg){
        producer.sendTopic(msg);
        return Result.success("1");
    }

    @RequestMapping(value = "/fanout", method = RequestMethod.POST)
    public Result<String> fanoutSend(String msg){
        producer.sendFanout(msg);
        return Result.success("1");
    }
    @RequestMapping(value = "/headers", method = RequestMethod.POST)
    public Result<String> headersSend(String msg){
        producer.sendHeaders(msg);
        return Result.success("1");
    }
}
