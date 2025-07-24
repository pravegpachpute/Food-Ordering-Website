package com.floobyte.franchise.exception;

import org.springframework.http.HttpStatus;

public class ApiRequestException extends RuntimeException{

    private final HttpStatus status;
    public ApiRequestException(String message, HttpStatus status) {
        super(message);
        this.status= status;

    }
}
