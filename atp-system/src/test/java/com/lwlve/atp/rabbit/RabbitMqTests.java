package com.lwlve.atp.rabbit;

import com.lwlve.atp.AtpApplication;
import com.lwlve.atp.common.constant.MqConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * rabbitmq 测试类
 *
 * @author Liuzheng
 * @date 2023/8/7 18:08
 */
@SpringBootTest(classes = AtpApplication.class)
@Slf4j
public class RabbitMqTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void sendRabbit(){
        String msg = "测试发给队列1消息";
        rabbitTemplate.convertAndSend(MqConstants.DEMO_TOPIC_DEMO,MqConstants.DEMO_ROUTE_KEY_DEMO1,msg);
    }

}
