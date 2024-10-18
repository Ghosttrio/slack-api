package com.ghosttrio.withslack.controller;

import com.ghosttrio.withslack.enums.Connection;
import com.ghosttrio.withslack.service.message.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/connections")
public class ConnectionController {

    private final MessageService messageService;

    @GetMapping
    public Connection connectionTest() {
        return Connection.UP;
    }

    @GetMapping("/messages")
    public String testMessageSend() {
        messageService.send();
        return "메시지 전송에 성공했습니다.";
    }
}
