package com.example.hotelk.hotelFacilityUsage.response;

import com.example.hotelk.hotel.domain.entity.Hotel;
import com.example.hotelk.hotelFacility.domain.entity.HotelFacility;
import com.example.hotelk.hotelFacilityUsage.domain.entity.HotelFacilityUsage;
import jakarta.persistence.*;
import lombok.Getter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
public class HotelFacilityUsageResponse {

    private Long usageId;

//    private Hotel hotel;

    private Long hotelId;

    private String guestName;

//    private HotelFacility facility;

    private Long facilityId;
    private LocalDate usageDate;
    private LocalTime usageTime;

    public HotelFacilityUsageResponse(HotelFacilityUsage hotelFacilityUsage) {
        this.usageId = hotelFacilityUsage.getUsageId();
        this.hotelId = hotelFacilityUsage.getHotel().getHotelId();
        this.guestName = hotelFacilityUsage.getGuestName();
        this.facilityId = hotelFacilityUsage.getFacility().getFacilityId();
        this.usageDate = hotelFacilityUsage.getUsageDate();
        this.usageTime = hotelFacilityUsage.getUsageTime();
    }
}
