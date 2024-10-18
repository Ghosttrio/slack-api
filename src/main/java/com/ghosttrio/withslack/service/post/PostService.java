package com.ghosttrio.withslack.service.post;

import com.slack.api.methods.request.chat.ChatPostMessageRequest;

public interface PostService {
    void postMessage(ChatPostMessageRequest request);
    void postFile();
}
