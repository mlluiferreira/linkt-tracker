package com.bootcamp.linktracker.exception;

import org.springframework.http.HttpStatus;

public class InvalidUrlException extends AbstractGeralException {

    public InvalidUrlException(String message, Object requestData) {
        super(message, requestData, HttpStatus.BAD_REQUEST);
    }
}
