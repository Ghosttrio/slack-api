package com.ghosttrio.withslack.service.scheduler;

import com.ghosttrio.withslack.enums.SchedulerStatus;
import com.slack.api.model.block.LayoutBlock;

import java.util.List;

public interface SchedulerService {
    void on(String cron, String text);
    void on(String cron, List<LayoutBlock> blocks);
    void on(String cron, byte[] pdf, String comment);
    void off();
    void send();
    SchedulerStatus status();
}
