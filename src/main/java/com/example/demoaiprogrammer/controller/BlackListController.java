package com.example.demoaiprogrammer.controller;

import com.example.demoaiprogrammer.service.MsisdnBlackListService;
import com.example.demoaiprogrammer.service.impl.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BlackListController {
    private final MsisdnBlackListService msisdnBlackListService;
    private final MessageService messageService;

    public BlackListController(MsisdnBlackListService msisdnBlackListService, MessageService messageService) {
        this.msisdnBlackListService = msisdnBlackListService;
        this.messageService = messageService;
    }

    @GetMapping("/blacklist/{msisdn}")
    public ResponseEntity<?> isInMsisdnBlackList(@PathVariable String msisdn) {
        boolean inMsisdnBlackList = msisdnBlackListService.isInMsisdnBlackList(msisdn);
        messageService.sendMessage("hello", "test_topic");
        return ResponseEntity.ok(inMsisdnBlackList);
    }
}
