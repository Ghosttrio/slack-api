package com.ghosttrio.withslack.controller;

import com.ghosttrio.withslack.service.impl.ConnectionTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/connections")
public class ConnectionController {

    private final ConnectionTestService connectionTestService;

    @GetMapping
    public String connectionTest() {
        return "연결이 확인되었습니다.";
    }

    @GetMapping("/messages")
    public String testMessageSend() {
        connectionTestService.send();
        return "메시지 전송에 성공했습니다.";
    }
}
