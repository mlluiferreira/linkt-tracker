package com.bootcamp.linktracker.exception;

import org.springframework.http.HttpStatus;

public class AbstractGeralException extends RuntimeException {

    public Object requestData;

    public HttpStatus httpStatus;

    public AbstractGeralException(String message, Object requestData, HttpStatus httpStatus) {
        super(message);
        this.requestData = requestData;
        this.httpStatus = httpStatus;
    }
}
