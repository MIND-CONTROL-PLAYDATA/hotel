package com.example.hotelk.hotel.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class HotelFacilityRequest {
    private Long hotelId;
    private Long facilityId;

}
