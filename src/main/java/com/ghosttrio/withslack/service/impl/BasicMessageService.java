package com.ghosttrio.withslack.service.impl;

import com.ghosttrio.withslack.config.SlackProperties;
import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class BasicMessageService {

    private final SlackProperties slackProperties;

    public void send(String text) {
        ChatPostMessageRequest request = ChatPostMessageRequest.builder()
                .channel(slackProperties.getChannel()) // 채널명 or 채널 ID
                .text(text)
                .build();

        CreateMessageText messageText = () -> "test";
        messageText.create();


        try {
            MethodsClient methods = Slack.getInstance().methods(slackProperties.getToken());
            methods.chatPostMessage(request);
        } catch (IOException | SlackApiException e) {
            throw new RuntimeException(e);
        }
    }
}
