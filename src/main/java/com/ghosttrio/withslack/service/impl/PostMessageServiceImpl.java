package com.ghosttrio.withslack.service.impl;

import com.ghosttrio.withslack.service.PostMessageService;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class PostMessageServiceImpl implements PostMessageService {

    private final MethodsClient methodsClient;

    @Override
    public void post(ChatPostMessageRequest request) {
        try {
            methodsClient.chatPostMessage(request);
        } catch (IOException | SlackApiException e) {
            throw new RuntimeException(e);
        }
    }
}
