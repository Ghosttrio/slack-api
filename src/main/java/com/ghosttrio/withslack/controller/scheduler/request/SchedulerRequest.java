package com.ghosttrio.withslack.controller.scheduler.request;

public class SchedulerRequest {

    public record ON(
            String cron
    ) {}
}
