package com.ghosttrio.withslack.service.scheduler;

import com.ghosttrio.withslack.enums.MessageType;
import com.ghosttrio.withslack.enums.SchedulerStatus;
import com.ghosttrio.withslack.service.message.MessageService;
import com.slack.api.model.block.LayoutBlock;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ScheduledFuture;


@Component
public class SchedulerServiceImpl implements SchedulerService {

    private final ThreadPoolTaskScheduler taskScheduler;
    private ScheduledFuture<?> scheduledTask;
    private final MessageService messageService;

    public SchedulerServiceImpl(MessageService messageService) {
        this.taskScheduler = new ThreadPoolTaskScheduler();
        this.taskScheduler.initialize();
        this.messageService = messageService;
    }

    @Override
    public void on(String cron, String text) {
        off(); // 기존 스케줄러가 있다면 멈춘다
        scheduledTask = taskScheduler.schedule(() -> messageService.send(text), new CronTrigger(cron));
    }

    @Override
    public void on(String cron, List<LayoutBlock> blocks) {
        off(); // 기존 스케줄러가 있다면 멈춘다
        scheduledTask = taskScheduler.schedule(() -> messageService.send(blocks), new CronTrigger(cron));
    }

    @Override
    public void on(String cron, byte[] pdf, String comment) {
        off(); // 기존 스케줄러가 있다면 멈춘다
        scheduledTask = taskScheduler.schedule(() -> messageService.send(pdf, comment), new CronTrigger(cron));
    }

    @Override
    public void off() {
        if (scheduledTask != null) {
            scheduledTask.cancel(true);
        }
    }
    @Override
    public void send() {
        messageService.send();
    }

    @Override
    public SchedulerStatus status() {
        return null;
    }

}
