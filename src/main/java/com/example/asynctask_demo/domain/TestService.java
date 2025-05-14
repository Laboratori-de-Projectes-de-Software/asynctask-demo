package com.example.asynctask_demo.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {

    private final LongRunningUseCase useCase;

    public void test(int seconds) throws Exception {
        useCase.execute(seconds);
    }

}
