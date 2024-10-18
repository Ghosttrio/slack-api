package com.ghosttrio.withslack.controller;

import com.ghosttrio.withslack.enums.SchedulerStatus;
import com.ghosttrio.withslack.service.scheduler.SchedulerService;
import com.ghosttrio.withslack.service.scheduler.SchedulerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/scheduler")
public class ScheduleMessageController {

    private final SchedulerService schedulerService;

    @PostMapping("/start")
    public void startScheduler() {
        schedulerService.on();
    }

    @PostMapping("/stop")
    public void stopScheduler() {
        schedulerService.off();
    }

    @GetMapping("/status")
    public SchedulerStatus loadSchedulerStatus() {
        return schedulerService.status();
    }
}