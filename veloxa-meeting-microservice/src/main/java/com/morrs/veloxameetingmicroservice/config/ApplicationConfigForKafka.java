package com.morrs.veloxameetingmicroservice.config;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.morrs.veloxameetingmicroservice.brokerUtils.DataSender;
import com.morrs.veloxameetingmicroservice.brokerUtils.DataSenderKafka;
import com.morrs.veloxameetingmicroservice.api.presentation.UsersNotification;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.JacksonUtils;
import org.springframework.kafka.support.serializer.JsonSerializer;

@Configuration
@Slf4j
public class ApplicationConfigForKafka {

    private final String TOPIC = "users_added_at_meeting";

    @Bean
    public ObjectMapper objectMapper() {
        return JacksonUtils.enhancedObjectMapper();
    }

    @Bean
    public ProducerFactory<String, UsersNotification> producerFactory(KafkaProperties kafkaProperties, ObjectMapper objectMapper) {
        var props = kafkaProperties.buildProducerProperties();
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put((ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG), JsonSerializer.class);

        var kafkaProducerFactory = new DefaultKafkaProducerFactory<String, UsersNotification>(props);
        kafkaProducerFactory.setValueSerializer(new JsonSerializer<>(objectMapper));
        return kafkaProducerFactory;
    }

    @Bean
    public KafkaTemplate<String, UsersNotification> kafkaTemplate(
            ProducerFactory<String, UsersNotification> producerFactory) {
        return new KafkaTemplate<>(producerFactory);
    }

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name(TOPIC).partitions(1).replicas(1).build();
    }

    @Bean
    public DataSender dataSender(NewTopic topic, KafkaTemplate<String, UsersNotification> kafkaTemplate) {
        return new DataSenderKafka(topic.name(), kafkaTemplate);
    }

}
