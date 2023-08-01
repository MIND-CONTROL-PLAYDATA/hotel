package com.example.hotelk.hotelFacility.domain.response;

import com.example.hotelk.hotel.domain.entity.Hotel;
import com.example.hotelk.hotelFacility.domain.entity.HotelFacility;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Getter
public class HotelFacilityResponse {
    private Long facilityId;

    private Hotel hotel;

    private String name;
    private String description;

    public HotelFacilityResponse(HotelFacility hotelFacility) {
        this.facilityId = hotelFacility.getFacilityId();
        this.hotel = hotelFacility.getHotel();
        this.name = hotelFacility.getName();
        this.description = hotelFacility.getDescription();
    }
}
