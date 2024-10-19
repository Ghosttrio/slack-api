package com.ghosttrio.withslack.service.custom;

import com.ghosttrio.withslack.service.builder.MessageBuilder;
import com.ghosttrio.withslack.service.post.PostService;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomMessageLambda {
    private final PostService postService;
    private final MessageBuilder messageBuilder;

    public CustomBlocksMessage lamb() {
        return text -> {
            ChatPostMessageRequest request = messageBuilder.createBasicMessage(text);
            postService.postMessage(request);
        };
    }
}
