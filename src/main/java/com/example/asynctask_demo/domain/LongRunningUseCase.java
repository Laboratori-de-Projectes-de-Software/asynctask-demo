package com.example.asynctask_demo.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.FutureUtils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Component
@Slf4j
public class LongRunningUseCase {

    @Async
    public void execute(int seconds) throws InterruptedException {
        log.debug("seconds: {}", seconds);
        Thread.sleep(seconds * 1000L);
        log.info("Finished a very long running task!");
    }

    @Async
    public CompletableFuture<String> executeString(int seconds) throws InterruptedException {
        log.debug("seconds: {}", seconds);
        Thread.sleep(seconds * 1000L);
        log.info("Finished a very long running task!");
        String result = "Hello, world!";
        return CompletableFuture.supplyAsync(() -> result);
    }

}
