package com.example.demo.RestController;

public class CustomNotFoundException extends RuntimeException{

    public CustomNotFoundException(String msg) {
        super(msg);
    }
}
