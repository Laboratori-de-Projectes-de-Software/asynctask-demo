package com.example.asynctask_demo.api;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ResponseDto {

    private int code;
    private String message;

}
