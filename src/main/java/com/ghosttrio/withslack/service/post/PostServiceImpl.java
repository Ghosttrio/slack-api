package com.ghosttrio.withslack.service.post;

import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.methods.request.files.FilesUploadRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final MethodsClient methodsClient;

    @Override
    public void postMessage(ChatPostMessageRequest request) {
        try {
            methodsClient.chatPostMessage(request);
        } catch (IOException | SlackApiException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void postFile(FilesUploadRequest request) {
        try {
            methodsClient.filesUpload(request);
        } catch (IOException | SlackApiException e) {
            throw new RuntimeException(e);
        }
    }
}
