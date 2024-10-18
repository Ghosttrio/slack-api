package com.ghosttrio.withslack.controller;

import com.ghosttrio.withslack.enums.SchedulerStatus;
import com.ghosttrio.withslack.service.impl.DynamicScheduler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/scheduler")
public class ScheduleMessageController {

    private final DynamicScheduler dynamicScheduler;

    @PostMapping("/start")
    public void startScheduler() {
        dynamicScheduler.on();
    }

    @PostMapping("/stop")
    public void stopScheduler() {
        dynamicScheduler.off();
    }

    @GetMapping("/status")
    public SchedulerStatus loadSchedulerStatus() {
        return dynamicScheduler.status();
    }
}