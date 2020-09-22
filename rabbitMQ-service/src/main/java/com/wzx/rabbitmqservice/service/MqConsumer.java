package com.wzx.rabbitmqservice.service;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MqConsumer {


    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void receive(String msg) {
        System.out.println("生产者1 massage  is "+msg);
    }

    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void receive2(String msg) {
        System.out.println("生产者2 massage  is "+msg);
    }

    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue,
                    exchange = @Exchange(value = "topic",type = "topic")
    )})
    public void receive3(String msg) {
        System.out.println("消费者1 massage  is "+msg);
    }
    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue,
                    exchange = @Exchange(value = "exchangeTest",type = "fanout")
            )})
    public void receive4(String msg) {
        System.out.println("消费者2 massage  is "+msg);
    }

    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue,
                    exchange = @Exchange(value = "topic",type = "topic"),
                    key = {"user.*"}
            )})
    public void receive5(String msg) {
        System.out.println("topic消费者1 massage  is "+msg);
    }

    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue,
                    exchange = @Exchange(value = "topic",type = "topic"),
                    key = {"order.#"}
            )})
    public void receive6(String msg) {
        System.out.println("topic消费者2 massage  is "+msg);
    }
}
