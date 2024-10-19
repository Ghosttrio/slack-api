package com.ghosttrio.withslack.controller.message;

import com.ghosttrio.withslack.controller.message.model.request.MessageRequest;
import com.ghosttrio.withslack.service.message.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping("/test")
    public ResponseEntity<String> testMessageSend() {
        messageService.send();
        return ResponseEntity.ok("Test 메시지 전송에 성공했습니다.");
    }

    @PostMapping("/text")
    public ResponseEntity<String> basicMessageSend(@RequestBody MessageRequest.Text request) {
        messageService.send(request.text());
        return ResponseEntity.ok("Text 메시지 전송에 성공했습니다.");
    }

    @PostMapping("/blocks")
    public ResponseEntity<String> sendBlocksMessage(@RequestBody MessageRequest.Blocks request) {
        messageService.send(request.blocks());
        return ResponseEntity.ok("Blocks 메시지 전송에 성공했습니다.");
    }

    @PostMapping("/pdf")
    public ResponseEntity<String> sendBlocksMessage(@RequestBody MessageRequest.Pdf request) {
        messageService.send(request.pdf(),request.comment());
        return ResponseEntity.ok("PDF 메시지 전송에 성공했습니다.");
    }

}
