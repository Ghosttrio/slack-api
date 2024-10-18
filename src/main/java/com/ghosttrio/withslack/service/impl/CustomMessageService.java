package com.ghosttrio.withslack.service.impl;

import com.ghosttrio.withslack.service.PostMessageService;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomMessageService {

    private final CreateMessageService createMessageService;
    private final PostMessageService postMessageService;

    public void send(String text) {
        ChatPostMessageRequest request = createMessageService.createBasicMessage(text);
        postMessageService.post(request);
    }

}
