package com.example.hotelk.amenities.domain.response;

import com.example.hotelk.amenities.domain.entity.Amenities;
import com.example.hotelk.hotel.domain.entity.Hotel;
import lombok.Getter;

import java.util.List;

@Getter
public class AmenitiesResponse {
    private Long amenityId;

//    private Hotel hotel;

    private Long hotelId;

    private String name;
    private String description;


    public AmenitiesResponse(Amenities amenities) {
        this.amenityId = amenities.getAmenityId();
        this.hotelId = amenities.getHotel().getHotelId();
        this.name = amenities.getName();
        this.description = amenities.getDescription();
    }
}