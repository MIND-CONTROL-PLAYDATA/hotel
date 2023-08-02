package com.example.hotelk.hotelFacility.domain.request;

import com.example.hotelk.hotel.domain.entity.Hotel;
import com.example.hotelk.hotelFacility.domain.entity.HotelFacility;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public record HotelFacilityRequest(Long hotelId, String name, String description) {
    // No need for additional methods in this record
}
