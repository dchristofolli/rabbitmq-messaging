package com.dchristofolli.messagingrabbitmq.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RabbitListener(queues = "message-boot")
public class Receiver {
    private final Logger log = LoggerFactory.getLogger(Receiver.class);

    @RabbitHandler
    public void receive(String message) {
        log.info(message);
    }
}
