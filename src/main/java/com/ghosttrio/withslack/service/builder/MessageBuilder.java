package com.ghosttrio.withslack.service.builder;

import com.ghosttrio.withslack.config.SlackProperties;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.model.block.Blocks;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageBuilder {

    private final SlackProperties slackProperties;

    public ChatPostMessageRequest createBasicMessage(String text) {
        return ChatPostMessageRequest.builder()
                .channel(slackProperties.getChannel()) // 채널명 or 채널 ID
                .text(text)
                .build();
    }

    public Blocks createBlocks() {
        return null;
    }
}
