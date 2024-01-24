package com.microservices.email.consumers;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.microservices.email.dto.EmailRecordDTO;
import com.microservices.email.models.EmailModel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.Payload;

@Configuration
public class EmailConsumer {
    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenEmailQueue(@Payload EmailRecordDTO emailRecordDTO) {
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailRecordDTO, emailModel);

    }
}
