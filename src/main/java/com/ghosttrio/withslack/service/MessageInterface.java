package com.ghosttrio.withslack.service;

import com.slack.api.model.block.Blocks;

public interface MessageInterface {
    /**
     * - 슬랙으로 기본 메시지 보내기
     * - 슬랙으로 text 메시지 보내기
     * - 슬랙으로 Block 메시지 보내기
     * - 슬랙으로 pdf 메시지 보내기
     * - 슬랙으로 커스텀 메시지 보내기
     * - 슬랙으로 메시지 스케줄링해서 보내기
     * - 슬랙으로 여러 채널에 메시지 보내기
     * - 기능들을 커스텀 할 수 있게 인터페이스 제공
     */
    void send();
    void send(String text);
    void send(Blocks blocks);
    void send(byte[] pdf);

}
