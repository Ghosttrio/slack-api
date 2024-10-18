package com.ghosttrio.withslack.controller;

import com.ghosttrio.withslack.service.message.MessageService;
import com.slack.api.model.block.LayoutBlock;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/blocks")
@RequiredArgsConstructor
public class BlocksMessageController {

    private final MessageService messageService;

    @GetMapping
    public String sendBlocksMessage(List<LayoutBlock> blocks) {
        messageService.send(blocks);
        return "ok";
    }
}
