package com.ghosttrio.withslack.service;

import com.slack.api.methods.request.chat.ChatPostMessageRequest;

public interface PostMessageService {
    void post(ChatPostMessageRequest request);
}
