package com.example.asynctask_demo.api;

import com.example.asynctask_demo.domain.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestService service;

    @PostMapping(
            name = "test",
            path = "/test",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseDto test(@RequestBody RequestDto request) throws Exception {
        service.test(request.getSeconds());
        return ResponseDto.builder()
                .code(200)
                .message("OK")
                .build();

    }

}
