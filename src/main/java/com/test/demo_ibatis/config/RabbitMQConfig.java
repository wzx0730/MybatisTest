package com.test.demo_ibatis.config;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {


    public final static String QUEUE_NAME_1 = "spring-boot-queue1";
    public final static String QUEUE_NAME_2 = "spring-boot-queue2";

    public final static String EXCHANGE_NAME = "spring-boot-exchange";

    public final static String ROUTING_KEY = "spring-boot-key";


    // 创建队列

    @Bean

    public Queue queue() {

        return new Queue(QUEUE_NAME_1);

    }


    // 创建一个 topic 类型的交换器

    @Bean

    public TopicExchange exchange() {

        return new TopicExchange(EXCHANGE_NAME);

    }


    // 使用路由键（routingKey）把队列（Queue）绑定到交换器（Exchange）

    @Bean

    public Binding binding(Queue queue, TopicExchange exchange) {

        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);

    }


    @Bean

    public ConnectionFactory connectionFactory() {

        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("127.0.0.1", 5672);

        connectionFactory.setUsername("guest");

        connectionFactory.setPassword("guest");

        return connectionFactory;

    }


    @Bean

    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {

        Channel channel = connectionFactory().createConnection().createChannel(true);


        return new RabbitTemplate(connectionFactory);

    }


}
