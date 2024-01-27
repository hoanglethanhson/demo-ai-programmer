package com.example.demoaiprogrammer.controller;

import com.example.demoaiprogrammer.service.MsisdnBlackListService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BlackListController {
    private final MsisdnBlackListService msisdnBlackListService;

    public BlackListController(MsisdnBlackListService msisdnBlackListService) {
        this.msisdnBlackListService = msisdnBlackListService;
    }

    @GetMapping("/blacklist/{msisdn}")
    public ResponseEntity<?> isInMsisdnBlackList(@PathVariable String msisdn) {
        boolean inMsisdnBlackList = msisdnBlackListService.isInMsisdnBlackList(msisdn);
        return ResponseEntity.ok(inMsisdnBlackList);
    }
}
