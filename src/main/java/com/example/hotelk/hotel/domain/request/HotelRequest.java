package com.example.hotelk.hotel.domain.request;

import com.example.hotelk.hotel.domain.entity.Hotel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HotelRequest {
    private String name;
    private String description;
    private String address;
    private String phoneNumber;
    private String email;
    private String url;



public Hotel toEntity() {
    return Hotel
            .builder()
            .name(name)
            .description(description)
            .address(address)
            .phoneNumber(phoneNumber)
            .email(email)
            .url(url)
            .build();
}
}
