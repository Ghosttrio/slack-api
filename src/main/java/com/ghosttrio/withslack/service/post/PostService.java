package com.ghosttrio.withslack.service.post;

import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.methods.request.files.FilesUploadRequest;

public interface PostService {
    void postMessage(ChatPostMessageRequest request);
    void postFile(FilesUploadRequest request);
}
