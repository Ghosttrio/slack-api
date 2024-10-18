package com.ghosttrio.withslack.service.message;

import com.ghosttrio.withslack.service.builder.MessageBuilder;
import com.ghosttrio.withslack.service.post.PostService;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.LayoutBlock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final PostService postService;
    private final MessageBuilder messageBuilder;

    @Override
    public void send() {
        ChatPostMessageRequest request = messageBuilder.createBasicMessage("테스트 메시지가 도착했습니다!");
        postService.postMessage(request);
    }

    @Override
    public void send(String text) {
        ChatPostMessageRequest request = messageBuilder.createBasicMessage(text);
        postService.postMessage(request);
    }

    @Override
    public void send(List<LayoutBlock> blocks) {
        ChatPostMessageRequest request = messageBuilder.createBlocks(blocks);
        postService.postMessage(request);
    }

    @Override
    public void send(byte[] pdf) {

    }
}
