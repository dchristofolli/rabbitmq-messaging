package com.dchristofolli.messagingrabbitmq.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class Receiver {
    private static final Logger log = LoggerFactory.getLogger(Receiver.class);

    @RabbitListener(queues = "${rabbitmq.genericQueueName}")
    public void receiveMessage(final Message message) {
        log.info("Received message as generic: {}", message);
    }

    @RabbitListener(queues = "${rabbitmq.specificQueueName}")
    public void receiveMessage(final String customMessage) {
        log.info("Received message as specific class: {}", customMessage);
    }
}
