package com.ghosttrio.withslack.service.custom;

@FunctionalInterface
public interface CustomBlocksMessage {
    void send(String text);
}
