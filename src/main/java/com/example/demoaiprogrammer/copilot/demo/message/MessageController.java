package com.example.demoaiprogrammer.copilot.demo.message;

import org.springframework.stereotype.Controller;

@Controller
public class MessageController {
    //define messageService
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    //define sendMessage method that takes Message as parameter
    public void sendMessage(Message message){
        //call messageService.sendMessage
        messageService.sendMessage(message);
    }
}
