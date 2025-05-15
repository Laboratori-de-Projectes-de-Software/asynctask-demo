package com.example.asynctask_demo.domain;

import com.example.asynctask_demo.api.RequestDto;
import com.example.asynctask_demo.api.ResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
@Slf4j
public class SendRequestUseCase {

    private final RestTemplate restTemplate;

    void execute(int seconds) {
        RequestDto body = RequestDto.builder()
                .seconds(seconds)
                .build();
        HttpEntity<RequestDto> entity = new HttpEntity<>(body);
        ResponseEntity<ResponseDto> response = restTemplate.exchange("http://localhost:8080/test", HttpMethod.POST, entity, ResponseDto.class);
        if(response.getStatusCode().is2xxSuccessful()) {
            ResponseDto responseBody = response.getBody();
            log.info("Response received:\n\tCode: {}\n\tMessage: {}", responseBody.getCode(), responseBody.getMessage());
        } else {
            log.error("Unsuccessful request: {}", response.getStatusCode().value());
        }
    }
}
