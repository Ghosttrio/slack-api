package com.ghosttrio.withslack.controller;

import com.ghosttrio.withslack.service.message.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pdfs")
public class PdfMessageController {

    private final MessageService messageService;

    @GetMapping
    public String sendBlocksMessage() {
        messageService.send(new byte[]{});
        return "ok";
    }
}
