package com.ghosttrio.withslack.service.message;

import com.slack.api.model.block.LayoutBlock;

import java.util.List;

public interface MessageService {
    void send();
    void send(String text);
    void send(List<LayoutBlock> blocks);
    void send(byte[] pdf, String comment);


    /**
     * - 슬랙으로 커스텀 메시지 보내기
     * - 슬랙으로 메시지 스케줄링해서 보내기
     * - 슬랙으로 여러 채널에 메시지 보내기
     * - 기능들을 커스텀 할 수 있게 인터페이스 제공
     */
}
