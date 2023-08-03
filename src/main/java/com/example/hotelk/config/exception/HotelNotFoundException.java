package com.example.hotelk.config.exception;

public class HotelNotFoundException extends RuntimeException{
    public HotelNotFoundException(String message) {
        super(message);
    }
}
