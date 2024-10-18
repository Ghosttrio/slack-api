package com.ghosttrio.withslack.service.impl;

import com.ghosttrio.withslack.config.SlackProperties;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateMessageService {

    private final SlackProperties slackProperties;

    public ChatPostMessageRequest createBasicMessage(String text) {
        return ChatPostMessageRequest.builder()
                .channel(slackProperties.getChannel()) // 채널명 or 채널 ID
                .text(text)
                .build();
    }
}
