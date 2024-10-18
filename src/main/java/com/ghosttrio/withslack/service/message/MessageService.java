package com.ghosttrio.withslack.service.message;

import com.slack.api.model.block.LayoutBlock;

import java.util.List;

public interface MessageService {
    void send(); // 슬랙으로 기본 메시지 보내기
    void send(String text); // 슬랙으로 text 메시지 보내기
    void send(List<LayoutBlock> blocks); // 슬랙으로 Blocks 메시지 보내기
    void send(String input, String test); // 슬랙으로 PDF 메시지 보내기


    /**
     * - 슬랙으로 커스텀 메시지 보내기
     * - 슬랙으로 메시지 스케줄링해서 보내기
     * - 슬랙으로 여러 채널에 메시지 보내기
     * - 기능들을 커스텀 할 수 있게 인터페이스 제공
     */
}
