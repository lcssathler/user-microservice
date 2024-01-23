package com.microservices.user.producers;

import com.microservices.user.dto.EmailDTO;
import com.microservices.user.models.UserModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {
    final RabbitTemplate rabbitTemplate;

    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value(value = "${broker.queue.email.name}")
    public String routingKey;

    public void publishMessageEmail(UserModel userModel) {
        EmailDTO emailDTO = new EmailDTO();
        emailDTO.setUserId(userModel.getId());
        emailDTO.setEmailTo(userModel.getEmail());
        emailDTO.setSubject("Success registration");
        emailDTO.setText(String.format("Hi, %s! \nYour registration has been successfully completed. Welcome to our team!"));

    }
}
