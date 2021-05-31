package com.bootcamp.linktracker.dto;

import com.bootcamp.linktracker.exception.AbstractGeralException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class ErrorInfoDTO {

    public final String url;

    public final String message;

    public final long timeStamp;

    public final String httpMethod;

    @JsonIgnore
    public HttpStatus statusCode;

    public Object request;

    public ErrorInfoDTO(String url, String message, long timeStamp, String httpMethod, Object request, HttpStatus statusCode) {
        this.url = url;
        this.message = message;
        this.timeStamp = timeStamp;
        this.httpMethod = httpMethod;
        this.request = request;
        this.statusCode = statusCode;
    }

    private ErrorInfoDTO(HttpServletRequest req, Exception ex) {
        this.url = req.getRequestURI();
        this.httpMethod = req.getMethod();
        this.message = ex.getMessage();
        this.timeStamp = new Date().getTime();
    }

    public void setObject(Object request) {
        this.request = request;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public static ErrorInfoDTO create(HttpServletRequest req, Exception ex) {
        ErrorInfoDTO errorInfo = new ErrorInfoDTO(req, ex);

        if (ex instanceof AbstractGeralException) {
            errorInfo.setObject(((AbstractGeralException) ex).requestData);
            errorInfo.setStatusCode(((AbstractGeralException) ex).httpStatus);
        }

        return errorInfo;
    }

}
