package com.better.cloud.server.mq.consumer.rabbit;

import com.better.cloud.server.mq.configure.rabbitmq.RabbitMQConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author: Mou Yiquan
 * @create: 2020/3/8 11:16
 * @description: rabbit mq user consumer
 **/
@Service
public class RabbitMQConsumer {

    private static Logger log = LoggerFactory.getLogger(RabbitMQConsumer.class);

    @RabbitListener(queues = RabbitMQConfig.DIRECT_COMMON_QUEUE)
    public void receive(String message){
        log.info("receive message:"+message);
    }

}
