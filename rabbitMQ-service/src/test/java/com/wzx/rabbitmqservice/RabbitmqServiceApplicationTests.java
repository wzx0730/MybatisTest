package com.wzx.rabbitmqservice;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitmqServiceApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Test
    void contextLoads() {
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("work","work模型: "+i);
        }
    }

    @Test
    void testFanOut(){

        rabbitTemplate.convertAndSend("topic","order.save.1" ,"topic的模型发送order" );
        rabbitTemplate.convertAndSend("topic","user.save" ,"topic的模型发送user" );
    }

}
