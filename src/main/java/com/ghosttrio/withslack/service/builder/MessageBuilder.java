package com.ghosttrio.withslack.service.builder;

import com.ghosttrio.withslack.config.SlackProperties;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.methods.request.files.FilesUploadRequest;
import com.slack.api.model.block.LayoutBlock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MessageBuilder {

    private final SlackProperties slackProperties;

    public ChatPostMessageRequest createBasicMessage(String text) {
        return ChatPostMessageRequest.builder()
                .channel(slackProperties.getChannel())
                .text(text)
                .build();
    }

    public ChatPostMessageRequest createBlocks(List<LayoutBlock> blocks) {
        return ChatPostMessageRequest.builder()
                .channel(slackProperties.getChannel())
                .blocks(blocks)
                .build();
    }

    public FilesUploadRequest createPdf(byte[] pdf, String comment) {
        return FilesUploadRequest.builder()
                .initialComment(comment)
                .fileData(pdf)
                .build();
    }
}
