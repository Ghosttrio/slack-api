package com.ghosttrio.withslack.controller;

import com.ghosttrio.withslack.service.impl.BasicMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/basics")
public class BasicMessageController {

    private final BasicMessageService basicMessageService;

    @GetMapping("/messages")
    public void basicMessageSend(@RequestParam String text) {
        basicMessageService.send(text);
    }
}
