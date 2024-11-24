package com.example.demoaiprogrammer.service.impl;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageListenerService {
    @KafkaListener(topics = "test_topic", groupId = "group_id",
            containerFactory = "consumerFactory")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }
}
