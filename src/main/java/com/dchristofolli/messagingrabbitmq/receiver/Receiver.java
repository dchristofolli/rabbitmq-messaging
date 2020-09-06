package com.dchristofolli.messagingrabbitmq.receiver;

import com.dchristofolli.messagingrabbitmq.model.UserEntity;
import com.dchristofolli.messagingrabbitmq.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
public class Receiver {
    private final UserRepository userRepository;
    private static final Logger log = LoggerFactory.getLogger(Receiver.class);

    public Receiver(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RabbitListener(queues = "${rabbitmq.specificQueueName}")
    @SendTo("${rabbitmq.responseQueueName}")
    public UserEntity receiveMessage(final UserEntity userEntity) {
        log.info("Received message as specific class: {}", userEntity);
        return userRepository.save(userEntity);
    }
}
