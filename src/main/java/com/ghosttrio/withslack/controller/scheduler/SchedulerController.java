package com.ghosttrio.withslack.controller.scheduler;

import com.ghosttrio.withslack.controller.scheduler.request.SchedulerRequest;
import com.ghosttrio.withslack.enums.SchedulerStatus;
import com.ghosttrio.withslack.service.scheduler.SchedulerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.ghosttrio.withslack.enums.SchedulerStatus.OFF;
import static com.ghosttrio.withslack.enums.SchedulerStatus.ON;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/schedulers")
public class SchedulerController {

    private final SchedulerService schedulerService;

    @PostMapping("/on")
    public ResponseEntity<String> startScheduler(@RequestBody SchedulerRequest.ON request) {
        schedulerService.on(request.cron());
        return ResponseEntity.ok(ON.getStatus());
    }

    @PostMapping("/off")
    public ResponseEntity<String> stopScheduler() {
        schedulerService.off();
        return ResponseEntity.ok(OFF.getStatus());
    }

    @GetMapping("/status")
    public ResponseEntity<SchedulerStatus> loadSchedulerStatus() {
        SchedulerStatus status = schedulerService.status();
        return ResponseEntity.ok(status);
    }
}