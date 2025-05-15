package com.example.asynctask_demo.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
@Slf4j
public class TestService {

    private final LongRunningUseCase longRunningUseCase;

    private final SendRequestUseCase sendRequestUseCase;

    public void test(int seconds) throws Exception {
        longRunningUseCase.execute(seconds);
    }

    public void testString(int seconds) throws Exception {
        CompletableFuture<String> stringFuture = longRunningUseCase.executeString(seconds);
        stringFuture.thenAccept(this::printMessage);
    }

    private void printMessage(String s) {
        log.info("result: {}", s);
        // Enviar mensaje al back-end

    }

    public void testRestTemplate(int seconds) {
        sendRequestUseCase.execute(seconds);
    }

}
