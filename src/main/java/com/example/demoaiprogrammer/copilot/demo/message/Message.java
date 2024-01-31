package com.example.demoaiprogrammer.copilot.demo.message;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {
    //define messageId, msisdn, message, and date
    private int messageId;
    private String msisdn;
    private String message;
    private String date;
}
