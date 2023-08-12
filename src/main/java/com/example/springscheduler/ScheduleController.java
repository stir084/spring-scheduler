package com.example.springscheduler;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;

import java.util.concurrent.ScheduledFuture;

@Configuration
@RequiredArgsConstructor
public class ScheduleController {

    private final ThreadPoolTaskScheduler taskScheduler;

    private static volatile int SCHEDULED_INTERVAL = 5;

    private final Runnable scheduledTask = () -> System.out.println("Scheduled task is running on thread: " + Thread.currentThread().getName());

    private ScheduledFuture<?> taskFuture;

    public void startScheduledTask() {
        stopScheduledTask();
        String cronExpression = String.format("0/%d * * * * ?", SCHEDULED_INTERVAL);
        taskFuture = taskScheduler.schedule(scheduledTask, new CronTrigger(cronExpression));
    }

    public void stopScheduledTask() {
        if (taskFuture != null) {
            taskFuture.cancel(true);
        }
    }

    public void changeAndRestartScheduledTask(int newInterval) {
        SCHEDULED_INTERVAL = newInterval;
        startScheduledTask();
    }
}