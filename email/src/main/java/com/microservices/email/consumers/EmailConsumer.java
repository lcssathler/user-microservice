package com.microservices.email.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailConsumer {
    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenEmailQueue(String message) {
        System.out.println(message);
    }
}
