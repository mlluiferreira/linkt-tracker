package com.bootcamp.linktracker.controller;

import com.bootcamp.linktracker.dto.ErrorInfoDTO;
import com.bootcamp.linktracker.exception.AbstractGeralException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(AbstractGeralException.class)
    public ResponseEntity<ErrorInfoDTO> catchExceptions(HttpServletRequest req, Exception exception) {
        ErrorInfoDTO errorInfo = ErrorInfoDTO.create(req, exception);
        return new ResponseEntity<>(errorInfo, errorInfo.statusCode);
    }

}
