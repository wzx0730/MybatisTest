package com.test.demo_ibatis.service.Impl;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MQServiceImpl {
    @Autowired
    private RabbitTemplate rabbitTemplate;


}
