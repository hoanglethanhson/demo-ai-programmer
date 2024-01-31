package com.example.demoaiprogrammer.config;

import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {
    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    @Bean
    public ProducerFactory<String, String> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    private Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put("bootstrap.servers", "localhost:9092");
         props.put("key.serializer", StringSerializer.class);
         props.put("value.serializer", StringSerializer.class);
         props.put("key.deserializer", StringDeserializer.class);
         props.put("value.deserializer", StringDeserializer.class);
         props.put("group.id", "group_id");
         props.put("auto.offset.reset", "earliest");
         props.put("enable.auto.commit", "false");
        return props;
    }
}
