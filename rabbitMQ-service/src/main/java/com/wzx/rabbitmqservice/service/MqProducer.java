package com.wzx.rabbitmqservice.service;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MqProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;


}
