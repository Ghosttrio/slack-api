package com.ghosttrio.withslack.controller.scheduler;

import com.ghosttrio.withslack.controller.scheduler.request.SchedulerRequest;
import com.ghosttrio.withslack.enums.SchedulerStatus;
import com.ghosttrio.withslack.service.scheduler.SchedulerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/schedulers")
public class SchedulerController {

    private final SchedulerService schedulerService;

    @PostMapping("/on")
    public ResponseEntity<String> startScheduler() {
        schedulerService.on();
        return ResponseEntity.ok("스케줄러 ON");
    }

    @PostMapping("/off")
    public ResponseEntity<String> stopScheduler() {
        schedulerService.off();
        return ResponseEntity.ok("스케줄러 OFF");
    }

    @GetMapping("/status")
    public ResponseEntity<SchedulerStatus> loadSchedulerStatus() {
        SchedulerStatus status = schedulerService.status();
        return ResponseEntity.ok(status);
    }

    @PostMapping("/rate")
    public ResponseEntity<String> setFixedRate(@RequestBody SchedulerRequest.FixedRate request) {
        schedulerService.setFixedRate(request.rate());
        return ResponseEntity.ok("스케줄러 주기가 [" + request.rate() + "]로 변경되었습니다.");
    }
}