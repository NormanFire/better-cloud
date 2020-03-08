package com.better.cloud.server.mq.configure.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Mou Yiquan
 * @create: 2020/3/8 11:02
 * @description: Rabbit MQ config
 **/
@Configuration
public class RabbitMQConfig {

    //Direct模式
    public static final String DIRECT_COMMON_QUEUE = "direct.common.queue";

    /**
     * Direct模式（直连模式） 交换机Exchange 四种
     * @return
     */
    @Bean
    public Queue queue(){
        return new Queue(DIRECT_COMMON_QUEUE,true);
    }


}
