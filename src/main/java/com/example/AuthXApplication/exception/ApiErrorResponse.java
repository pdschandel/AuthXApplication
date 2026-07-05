package com.example.AuthXApplication.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

@AllArgsConstructor
@Getter
@Builder
public class ApiErrorResponse {

    private Instant timestamp;

    private int status;

    private String error;

    private String message;

    private String path;

}