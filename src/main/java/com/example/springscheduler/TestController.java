package com.example.springscheduler;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequiredArgsConstructor
public class TestController {
    private final ScheduleController scheduleController;
    @GetMapping("/start")
    public ResponseEntity<?> start() {
        scheduleController.startScheduledTask();
        return ResponseEntity.ok("start");
    }
    @GetMapping("/stop")
    public ResponseEntity<?> stop() {
        scheduleController.stopScheduledTask();
        return ResponseEntity.ok("stop");
    }
    @GetMapping("/change")
    public ResponseEntity<?> changeConfig() {
        scheduleController.changeAndRestartScheduledTask(10);
        return ResponseEntity.ok("change");
    }
}

