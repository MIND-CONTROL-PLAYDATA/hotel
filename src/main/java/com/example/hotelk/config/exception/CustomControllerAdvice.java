package com.example.hotelk.config.exception;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.security.WeakKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomControllerAdvice {
    @ExceptionHandler(LoginFailException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse loginFailExceptionHandler(LoginFailException e){
        return new ErrorResponse(e.getMessage(), e.getCause());
    }
    @ExceptionHandler(ExistEmailException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse existEmailExceptionHandler(ExistEmailException e){
        return new ErrorResponse(e.getMessage(), e.getCause());
    }

    @ExceptionHandler(WeakKeyException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse weakKeyExceptionHandler(WeakKeyException e){
        return new ErrorResponse(
                "Tampered Token", e.getCause());
    }

    @ExceptionHandler(ExpiredJwtException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorResponse weakKeyExceptionHandler(ExpiredJwtException e){
        return new ErrorResponse(
                "Timeout Token", e.getCause());
    }

    @ExceptionHandler(HotelNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse hotelNotFoundExceptionHandler(HotelNotFoundException e){
        return new ErrorResponse(
                "Hotel Not Found", e.getCause());
    }

    @ExceptionHandler(HotelFacilityNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse hotelFacilityNotFoundExceptionHandler(HotelFacilityNotFoundException e){
        return new ErrorResponse(
                "Hotel Facility Not Found", e.getCause());
    }

    @ExceptionHandler(HotelFacilityUsageNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse hotelFacilityUsageNotFoundExceptionHandler(HotelFacilityUsageNotFoundException e){
        return new ErrorResponse(
                "Hotel Facility Usage Not Found", e.getCause());
    }

    @ExceptionHandler(RegionNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse RegionNotFoundExceptionHandler(RegionNotFoundException e){
        return new ErrorResponse(
                "Region Not Found", e.getCause());
    }
}
