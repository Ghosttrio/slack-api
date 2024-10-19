package com.ghosttrio.withslack.service.scheduler;

import com.ghosttrio.withslack.enums.SchedulerStatus;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.concurrent.ScheduledFuture;


@Component
public class SchedulerServiceImpl implements SchedulerService {

    private final ThreadPoolTaskScheduler taskScheduler;
    private ScheduledFuture<?> scheduledTask;

    public SchedulerServiceImpl() {
        this.taskScheduler = new ThreadPoolTaskScheduler();
        this.taskScheduler.initialize();
    }

    @Override
    public void on(String cron) {
        off(); // 기존 스케줄러가 있다면 멈춘다
        scheduledTask = taskScheduler.schedule(this::runScheduledTask, new CronTrigger(cron));
    }

    @Override
    public void off() {
        if (scheduledTask != null) {
            scheduledTask.cancel(true);
        }
    }

    private void runScheduledTask() {
        System.out.println("슬랙 메시지 보내기");
    }

    @Override
    public void send() {
        runScheduledTask();
    }

    @Override
    public SchedulerStatus status() {
        return null;
    }
}
