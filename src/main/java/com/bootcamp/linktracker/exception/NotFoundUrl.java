package com.bootcamp.linktracker.exception;

import org.springframework.http.HttpStatus;

public class NotFoundUrl extends AbstractGeralException {

    public NotFoundUrl(String message, Object requestData) {
        super(message, requestData, HttpStatus.BAD_REQUEST);
    }

}
