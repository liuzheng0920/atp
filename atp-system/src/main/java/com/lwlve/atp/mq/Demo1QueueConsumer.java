package com.lwlve.atp.mq;

import com.lwlve.atp.common.constant.MqConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * Demo1Queue 消费者
 *
 * @author Liuzheng
 * @date 2023/8/7 15:55
 */

@RabbitListener(queues = MqConstants.DEMO_QUEUE_DEMO1)
@Component
@Slf4j
public class Demo1QueueConsumer {

    /**
     * mq消费实现
     */
    @RabbitHandler
    public void recviced(@Payload String msg){
        log.info("mq [{}]:{}",MqConstants.DEMO_QUEUE_DEMO1,msg);
    }

}
