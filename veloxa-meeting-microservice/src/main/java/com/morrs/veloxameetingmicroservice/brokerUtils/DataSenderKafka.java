package com.morrs.veloxameetingmicroservice.brokerUtils;

import com.morrs.veloxameetingmicroservice.api.presentation.UsersNotification;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;

@Slf4j
@AllArgsConstructor
public class DataSenderKafka implements DataSender {

    private String topic;
    private KafkaTemplate<String, UsersNotification> kafkaTemplate;


    @Override
    public void send(UsersNotification usersNotification) {
        try {
            log.info("value:{}", usersNotification);
            kafkaTemplate.send(topic, usersNotification)
                    .whenComplete((result, e) -> {
                        if (e == null) {
                            log.info(
                                    "message id:{} was sent, offset:{}",
                                    usersNotification.getId(),
                                    result.getRecordMetadata().offset()
                            );
                        } else {
                            log.error("message id:{} was not sent", usersNotification.getId(), e);
                        }
                    });
        } catch (Exception ex) {
            log.error("send error, value:{}", usersNotification, ex);
        }
    }
}
