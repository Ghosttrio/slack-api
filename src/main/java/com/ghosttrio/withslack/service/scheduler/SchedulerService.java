package com.ghosttrio.withslack.service.scheduler;

import com.ghosttrio.withslack.enums.SchedulerStatus;

public interface SchedulerService {
    /**
     * 1. 스케줄러 on
     * 2. 스케줄러 off
     * 3. 스케줄러 상태 체크
     * 4. 스케줄러 메시지 내용 전송
     * 5. 스케줄러 시간 설정
     */
    void on();
    void off();
    void send();
    void setFixedRate(String rate);
    SchedulerStatus status();
}
