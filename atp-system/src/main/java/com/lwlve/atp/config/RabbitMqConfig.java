package com.lwlve.atp.config;

import com.lwlve.atp.common.constant.MqConstants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  RabbitMq  配置
 *
 * @author Liuzheng
 * @date 2023/8/4 11:18
 */

@Configuration
public class RabbitMqConfig {

    @Bean
    public TopicExchange demoTopicExchange(){
        return new TopicExchange(MqConstants.DEMO_TOPIC_DEMO);
    }

    @Bean
    public Queue demo1Queue(){
        return new Queue(MqConstants.DEMO_QUEUE_DEMO1);
    }

    @Bean
    public Queue demo2Queue(){
        return new Queue(MqConstants.DEMO_QUEUE_DEMO2);
    }


    @Bean
    public Binding bindingDemoTopicExchangeWithDemo1Queue(){
        return BindingBuilder.bind(demo1Queue()).to(demoTopicExchange()).with(MqConstants.DEMO_ROUTE_KEY_DEMO1);
    }

    @Bean
    public Binding bindingDemoTopicExchangeWithDemo2Queue(){
        return BindingBuilder.bind(demo2Queue()).to(demoTopicExchange()).with(MqConstants.DEMO_ROUTE_KEY_DEMO2);
    }

}
