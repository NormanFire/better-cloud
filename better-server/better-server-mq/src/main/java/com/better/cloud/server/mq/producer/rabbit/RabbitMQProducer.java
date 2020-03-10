package com.better.cloud.server.mq.producer.rabbit;

import com.better.cloud.common.utils.StringBeanUtil;
import com.better.cloud.server.mq.configure.rabbitmq.RabbitMQConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Mou Yiquan
 * @create: 2020/3/8 11:09
 * @description: rabbit mq user producer
 **/
@Service
public class RabbitMQProducer {

    private static Logger log = LoggerFactory.getLogger(RabbitMQProducer.class);

    @Autowired
    AmqpTemplate amqpTemplate;

    public void send(Object message){
        String msg = StringBeanUtil.beanToString(message);
        log.info("rabbitmq direct exchange send message:"+msg);
        amqpTemplate.convertAndSend(RabbitMQConfig.DIRECT_COMMON_QUEUE,msg);
    }

    public void sendTopic(Object message){
        String msg = StringBeanUtil.beanToString(message);
        log.info("rabbitmq topic exchange send message:"+msg);
        amqpTemplate.convertAndSend(RabbitMQConfig.TOPIC_COMMON_EXCHANGE,"topic.1",msg);
        amqpTemplate.convertAndSend(RabbitMQConfig.TOPIC_COMMON_EXCHANGE,"topic.2",msg);
    }

    public void sendFanout(Object message){
        String msg = StringBeanUtil.beanToString(message);
        log.info("rabbitmq fanout exchange send message:"+msg);
        amqpTemplate.convertAndSend(RabbitMQConfig.FANOUT_COMMON_EXCHANGE,"",msg);
    }
}
