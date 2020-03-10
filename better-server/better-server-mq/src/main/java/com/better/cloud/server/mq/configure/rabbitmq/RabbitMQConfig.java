package com.better.cloud.server.mq.configure.rabbitmq;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.amqp.core.*;
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
    //fanout广播模式
    public static final String FANOUT_COMMON_QUEUE1 = "fanout.common.queue1";
    public static final String FANOUT_COMMON_QUEUE2 = "fanout.common.queue1";
    public static final String FANOUT_COMMON_EXCHANGE = "fanoutCommonChange";
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
    public Queue fanoutQueue1(){
        return new Queue(FANOUT_COMMON_QUEUE1,true);
    }
    @Bean
    public Queue fanoutQueue2(){
        return new Queue(FANOUT_COMMON_QUEUE2,true);
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
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange(FANOUT_COMMON_EXCHANGE);
    }
    @Bean
    public Binding fanoutBinding1(){
        return BindingBuilder.bind(fanoutQueue1()).to(fanoutExchange());
    }
    @Bean
    public Binding fanoutBinding2(){
        return BindingBuilder.bind(fanoutQueue2()).to(fanoutExchange());
    }

}
