package com.ghosttrio.withslack.service.message;

import com.slack.api.model.block.LayoutBlock;

import java.util.List;

public interface MessageService {
    void send();
    void send(String text);
    void send(List<LayoutBlock> blocks);
    void send(byte[] pdf, String comment);
}
