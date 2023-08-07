package com.lwlve.atp.framework.config;

import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty("spring.rabbitmq.enable")
public class MyRabbitAutoConfiguration extends RabbitAutoConfiguration {

}
