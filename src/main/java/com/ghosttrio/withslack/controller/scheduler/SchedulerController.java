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
@RequestMapping("/api/slack/schedulers")
public class SchedulerController {

    private final SchedulerService schedulerService;

    @PostMapping("/test")
    public ResponseEntity<String> testSchedulerMessage() {
        schedulerService.send();
        return ResponseEntity.ok(OFF.getStatus());
    }

    @PostMapping("/text")
    public ResponseEntity<String> startTextScheduler(@RequestBody SchedulerRequest.Text request) {
        schedulerService.on(request.cron(), request.text());
        return ResponseEntity.ok(ON.getStatus());
    }

    @PostMapping("/blocks")
    public ResponseEntity<String> startBlocksScheduler(@RequestBody SchedulerRequest.Blocks request) {
        schedulerService.on(request.cron(), request.blocks());
        return ResponseEntity.ok(ON.getStatus());
    }

    @PostMapping("/pdf")
    public ResponseEntity<String> startPdfScheduler(@RequestBody SchedulerRequest.Pdf request) {
        schedulerService.on(request.cron(), request.pdf(), request.comment());
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