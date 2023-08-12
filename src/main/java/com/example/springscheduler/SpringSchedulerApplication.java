package com.example.springscheduler;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.PeriodicTrigger;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class SpringSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSchedulerApplication.class, args);

		/*ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
		taskScheduler.initialize();

		Runnable task = () -> {
			System.out.println("Scheduled tfbask is running on thread: " + Thread.currentThread().getName());
		};

		taskScheduler.schedule(task, new PeriodicTrigger(3000));*/
	}

	/*@PostConstruct
	public void test24() throws InterruptedException {
		System.out.println("Scheduled async task is running on thread: " + Thread.currentThread().getName());
	}*/
	//http://localhost:8080/actuator/metrics/jvm.threads.live
	//@Scheduled(fixedDelay = 3000)
	public void test() throws InterruptedException {
		System.out.println("Scheduled async task is running on thread1: " + Thread.currentThread().getName());
	}

	//@Async
	//@Scheduled(fixedDelay = 1000) // 3초마다 실행
	public void test2() throws InterruptedException {
		System.out.println("Scheduled async task is running on thread2: " + Thread.currentThread().getName());
		Thread.sleep(11111000); // 비동기적으로 실행되는 메서드 내에서 작업 수행
	}
}
