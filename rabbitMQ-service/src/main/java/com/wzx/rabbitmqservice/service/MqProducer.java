package com.wzx.rabbitmqservice.service;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MqProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendTimeMsg(){
        rabbitTemplate.convertAndSend("exchangeTest666" ,"","消息啊啊啊啊啊",message -> {
            message.getMessageProperties().setExpiration("10000");
            return message;
        } );
    }
}
