package com.example.AuthXApplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ApiErrorResponse> handleEmailAlreadyExistsException(EmailAlreadyExistsException emailAlreadyExistsException){
        ApiErrorResponse apiErrorResponse = ApiErrorResponse.builder()
                .timestamp(Instant.now())
                .error(HttpStatus.CONFLICT.getReasonPhrase())
                .path("")
                .status(HttpStatus.CONFLICT.value())
                .message(emailAlreadyExistsException.getMessage())
                .build();
//        System.out.println("This email is already existed !!!!!!!!!!!!!");
        return new ResponseEntity<>(apiErrorResponse, HttpStatus.CONFLICT);
    }

}
