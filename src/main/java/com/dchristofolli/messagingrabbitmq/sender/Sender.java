package com.dchristofolli.messagingrabbitmq.sender;

import com.dchristofolli.messagingrabbitmq.configuration.RabbitmqConfiguration;
import com.dchristofolli.messagingrabbitmq.receiver.Receiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class Sender implements CommandLineRunner {
    private final Logger log = LoggerFactory.getLogger(Sender.class);
    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;

    public Sender(Receiver receiver, RabbitTemplate rabbitTemplate) {
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Sending message...");
        rabbitTemplate.convertAndSend(
            RabbitmqConfiguration.TOPIC_EXCHANGE_NAME,
            "foo.bar.baz",
            "Hello from RabbitMQ!");
        receiver.getLatch().await(10, TimeUnit.SECONDS);
    }
}
