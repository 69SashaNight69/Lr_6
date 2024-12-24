package com.Lr6.demo;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class DelayedMessagePrinter {

    @Async
    @Scheduled(fixedDelay = 5000, initialDelay = 5000)
    public void printMessage() {
        try {
            TimeUnit.SECONDS.sleep(1); // Затримка для демонстрації асинхронності
            System.out.println("5 seconds have passed since the program started.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Task interrupted: " + e.getMessage());
        }
    }
}
