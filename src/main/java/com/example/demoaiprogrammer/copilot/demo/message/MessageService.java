package com.example.demoaiprogrammer.copilot.demo.message;

import com.example.demoaiprogrammer.copilot.demo.kafka.KafkaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class MessageService {
    @Value("${message.url}")
    private  String url;
    @Value("${message.success-topic}")
    private String successTopic;

    @Value("${message.failure-topic}")
    private String failureTopic;

    private final KafkaService kafkaService;

    public MessageService(KafkaService kafkaService) {
        this.kafkaService = kafkaService;
    }

    public void sendMessage(Message message){
        //send message to url using restTemplate and return SendResult
        RestTemplate restTemplate = new RestTemplate();
        SendResult sendResult = restTemplate.postForObject(url, message, SendResult.class);
        //if sendResult status is not success, throw new RuntimeException with sendResult message
        if(!sendResult.getStatus().equals("success")){
            kafkaService.sendMessage(failureTopic, sendResult.getMessage());
            log.error("Error sending message id: {}", sendResult.getMessageId());
            throw new RuntimeException(sendResult.getMessage());
        } else {
            log.info("Message id: {} sent successfully", sendResult.getMessageId());
            kafkaService.sendMessage(successTopic, sendResult.getMessage());
        }
    }

}
