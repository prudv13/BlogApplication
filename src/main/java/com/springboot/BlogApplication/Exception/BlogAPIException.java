package com.springboot.BlogApplication.Exception;

import org.springframework.http.HttpStatus;

public class BlogAPIException extends RuntimeException{

    private HttpStatus status;
    private String message;

    public BlogAPIException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public BlogAPIException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus(){
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
