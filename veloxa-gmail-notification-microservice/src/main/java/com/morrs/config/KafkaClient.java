package com.morrs.config;

import com.morrs.dto.UsersNotification;
import com.morrs.mail_sender.MailSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KafkaClient {

    private final MailSender mailSender;
    private static final Logger log = LoggerFactory.getLogger(KafkaClient.class);

    public KafkaClient(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    @KafkaListener(
            topics = "${application.kafka.topic}",
            containerFactory = "listenerContainerFactory"
    )
    public void listen(@Payload List<UsersNotification> values) {
        log.info("values, values.size:{}", values.size());
        for (UsersNotification value : values) {
            value.getUsers().forEach(user -> {
                log.info(user.toString());
                mailSender.send(user.getEmail(), "Новая встреча", "Вас пригласили на встречу!");
            });

        }
    }
}
