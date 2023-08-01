package com.example.hotelk.amenities.domain.request;

import com.example.hotelk.amenities.domain.entity.Amenities;
import com.example.hotelk.hotel.domain.entity.Hotel;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public record AmenitiesRequest(Hotel hotel,String name,String description) {

    public Amenities toEntity() {
        return Amenities.builder().hotel(hotel).name(name).description(description).build();
    }
}
