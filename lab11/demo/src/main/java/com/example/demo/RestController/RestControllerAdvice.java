package com.example.demo.RestController;

import org.springframework.web.bind.annotation.ExceptionHandler;
@org.springframework.web.bind.annotation.RestControllerAdvice
public class RestControllerAdvice extends RuntimeException{

    @ExceptionHandler(CustomNotFoundException.class)
    public String handleNotFoundException(CustomNotFoundException ex) {
        String responseMsg = ex.getMessage();
        return responseMsg;
    }
}