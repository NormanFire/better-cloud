package com.better.cloud.server.mq.configure.rabbitmq;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
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

    //Topic 订阅模式
    public static final String TOPIC_COMMON_QUEUE1 = "topic.common.queue1";
    public static final String TOPIC_COMMON_QUEUE2 = "topic.common.queue2";
    public static final String TOPIC_COMMON_EXCHANGE = "topicCommonChange";
    //#代表0~n  *:一个
    public static final String TOPIC_COMMON_ROUTE_KEY1 = "topic.1";
    public static final String TOPIC_COMMON_ROUTE_KEY2 = "topic.#";
    /**
     * Direct模式（直连模式） 交换机Exchange 四种
     * @return
     */
    @Bean
    public Queue queue(){
        return new Queue(DIRECT_COMMON_QUEUE,true);
    }
    @Bean
    public Queue topicQueue1(){
        return new Queue(TOPIC_COMMON_QUEUE1,true);
    }
    @Bean
    public Queue topicQueue2(){
        return new Queue(TOPIC_COMMON_QUEUE2,true);
    }
    @Bean
    public TopicExchange topicCommonExchange(){
        return new TopicExchange(TOPIC_COMMON_EXCHANGE);
    }
    @Bean
    public Binding topicBinding1(){
        return BindingBuilder.bind(topicQueue1()).to(topicCommonExchange()).with(TOPIC_COMMON_ROUTE_KEY1);
    }
    @Bean
    public Binding topicBinding2(){
        return BindingBuilder.bind(topicQueue2()).to(topicCommonExchange()).with(TOPIC_COMMON_ROUTE_KEY2);
    }

}
