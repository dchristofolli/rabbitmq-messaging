package com.dchristofolli.messagingrabbitmq.receiver;

import com.dchristofolli.messagingrabbitmq.model.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class Receiver {
    private static final Logger log = LoggerFactory.getLogger(Receiver.class);

    @RabbitListener(queues = "${rabbitmq.specificQueueName}")
    public void receiveMessage(final UserEntity userEntity) {
        log.info("Received message as specific class: {}", userEntity);
    }
}
