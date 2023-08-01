package com.example.hotelk.hotelFacilityUsage.domain.request;

import com.example.hotelk.hotel.domain.entity.Hotel;
import com.example.hotelk.hotelFacility.domain.entity.HotelFacility;
import com.example.hotelk.hotelFacilityUsage.domain.entity.HotelFacilityUsage;

import java.sql.Timestamp;

public record HotelFacilityUsageRequest(Hotel hotel,String guestName,HotelFacility facility,
                                        Timestamp usageDate, Timestamp usageTime) {

    public HotelFacilityUsage toEntity() {
      return HotelFacilityUsage.builder().hotel(hotel).guestName(guestName).facility(facility)
                .usageDate(usageDate).usageTime(usageTime).build();
    }
}
