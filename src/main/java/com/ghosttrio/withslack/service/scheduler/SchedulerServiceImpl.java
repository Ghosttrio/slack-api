package com.ghosttrio.withslack.service.scheduler;

import com.ghosttrio.withslack.enums.SchedulerStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Component;

import java.util.concurrent.ScheduledFuture;

import static com.ghosttrio.withslack.enums.SchedulerStatus.OFF;
import static com.ghosttrio.withslack.enums.SchedulerStatus.ON;

@Component
@RequiredArgsConstructor
public class SchedulerServiceImpl implements SchedulerService {

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
    public void setFixedRate(String rate) {

    }
}
