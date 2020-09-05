package com.dchristofolli.messagingrabbitmq.receiver;

import com.dchristofolli.messagingrabbitmq.model.UserEntity;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RabbitListener(queues = "${rabbitmq.queueName}")
public class Receiver {
    private final Logger log = LoggerFactory.getLogger(Receiver.class);
    Gson gson;

    @RabbitHandler
    public void receive(UserEntity userEntity) {
//        Message msg = gson.fromJson(userEntity, Message.class);
        log.info(userEntity.toString());
    }
}
