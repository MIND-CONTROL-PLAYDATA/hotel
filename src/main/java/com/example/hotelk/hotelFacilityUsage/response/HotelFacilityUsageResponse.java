package com.example.hotelk.hotelFacilityUsage.response;

import com.example.hotelk.hotel.domain.entity.Hotel;
import com.example.hotelk.hotelFacility.domain.entity.HotelFacility;
import com.example.hotelk.hotelFacilityUsage.domain.entity.HotelFacilityUsage;
import jakarta.persistence.*;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class HotelFacilityUsageResponse {

    private Long usageId;

    private Hotel hotel;

    private String guestName;

    private HotelFacility facility;

    private Timestamp usageDate;
    private Timestamp usageTime;

    public HotelFacilityUsageResponse(HotelFacilityUsage hotelFacilityUsage) {
        this.usageId = hotelFacilityUsage.getUsageId();
        this.hotel = hotelFacilityUsage.getHotel();
        this.guestName = hotelFacilityUsage.getGuestName();
        this.facility = hotelFacilityUsage.getFacility();
        this.usageDate = hotelFacilityUsage.getUsageDate();
        this.usageTime = hotelFacilityUsage.getUsageTime();
    }
}
