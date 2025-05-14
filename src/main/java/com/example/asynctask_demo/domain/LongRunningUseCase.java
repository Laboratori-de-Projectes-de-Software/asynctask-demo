package com.example.asynctask_demo.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LongRunningUseCase {

    @Async
    public void execute(int seconds) throws InterruptedException {
        log.debug("seconds: {}", seconds);
        Thread.sleep(seconds * 1000L);
        log.info("Finished a very long running task!");
    }

}
