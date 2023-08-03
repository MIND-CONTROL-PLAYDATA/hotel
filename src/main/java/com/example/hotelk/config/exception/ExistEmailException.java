package com.example.hotelk.config.exception;

public class ExistEmailException extends RuntimeException{
    public ExistEmailException(String message) {
        super(message);
    }
}
