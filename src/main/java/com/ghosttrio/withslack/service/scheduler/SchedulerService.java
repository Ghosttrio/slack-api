package com.ghosttrio.withslack.service.scheduler;

import com.ghosttrio.withslack.enums.SchedulerStatus;

public interface SchedulerService {
    void on(String cron);
    void off();
    void send();
    SchedulerStatus status();
}
