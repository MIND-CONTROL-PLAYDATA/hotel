package com.example.hotelk.hotelFacility.domain.request;

import com.example.hotelk.hotel.domain.entity.Hotel;
import com.example.hotelk.hotelFacility.domain.entity.HotelFacility;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public record HotelFacilityRequest(Hotel hotel, String name, String description) {

    public HotelFacility toEntity() {
        return HotelFacility.builder().hotel(hotel).name(name).description(description).build();
    }
}
