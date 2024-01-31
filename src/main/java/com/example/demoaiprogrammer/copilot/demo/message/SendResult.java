package com.example.demoaiprogrammer.copilot.demo.message;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendResult {
    private String status;
    private String message;
    private String messageId;

    public SendResult(String status, String message){
        this.status = status;
        this.message = message;
    }
}
