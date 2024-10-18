package com.ghosttrio.withslack.service.impl;

import com.ghosttrio.withslack.enums.SchedulerStatus;
import com.ghosttrio.withslack.service.SchedulerInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Component;

import java.util.concurrent.ScheduledFuture;

import static com.ghosttrio.withslack.enums.SchedulerStatus.OFF;
import static com.ghosttrio.withslack.enums.SchedulerStatus.ON;

@Component
@RequiredArgsConstructor
public class DynamicScheduler implements SchedulerInterface {

    private final TaskScheduler taskScheduler;

    private ScheduledFuture<?> scheduledFuture;

    @Override
    public void on() {
        if (scheduledFuture == null || scheduledFuture.isCancelled()) {
            scheduledFuture = taskScheduler.scheduleWithFixedDelay(() -> {
                System.out.println("Test");
            }, 1000);
        }
    }

    @Override
    public void off() {
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            scheduledFuture = null;
        }
    }

    @Override
    public SchedulerStatus status() {
        return scheduledFuture == null ? ON : OFF;
    }

    @Override
    public void send() {

    }

    @Override
    public void setFixedRate() {

    }
}
