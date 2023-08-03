package com.example.hotelk.hotel.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class HotelFacilityUsageRequest {
    private Long hotelId;
    private Long usageId;
}
