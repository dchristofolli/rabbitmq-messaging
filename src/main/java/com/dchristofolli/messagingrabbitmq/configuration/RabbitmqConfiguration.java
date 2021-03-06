package com.dchristofolli.messagingrabbitmq.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfiguration {
    @Value("${rabbitmq.exchangeName}")
    private String exchangeName;

    @Value("${rabbitmq.specificQueueName}")
    private String specificQueueName;

    @Value("${rabbitmq.responseQueueName}")
    private String responseQueueName;

    @Value("${rabbitmq.routingKey}")
    private String routingKey;

    @Bean
    public TopicExchange appExchange() {
        return new TopicExchange(exchangeName);
    }

    @Bean
    public Queue appQueueSpecific() {
        return new Queue(specificQueueName);
    }

    @Bean
    public Queue responseQueue() {
        return new Queue(responseQueueName);
    }


    @Bean
    public Binding declareBindingSpecific() {
        return BindingBuilder.bind(appQueueSpecific()).to(appExchange()).with(routingKey);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        final var rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
