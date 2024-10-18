package com.ghosttrio.withslack.controller;

import com.ghosttrio.withslack.service.message.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/blocks")
@RequiredArgsConstructor
public class BlocksMessageController {

    private final MessageService messageService;

    @GetMapping
    public String sendBlocksMessage() {
        messageService.send();
        return "ok";
    }
}
