package com.example.hotelk.global.domain.response;

import com.example.hotelk.global.domain.entity.FacilityUsage;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
public class FacilityUsageResponse {

    private Long usageId;

//    private Hotel hotel;

    private Long hotelId;

    private String guestName;

//    private HotelFacility facility;

    private Long facilityId;
    private LocalDate usageDate;
    private LocalTime usageTime;

    public FacilityUsageResponse(FacilityUsage hotelFacilityUsage) {
        this.usageId = hotelFacilityUsage.getUsageId();
        this.hotelId = hotelFacilityUsage.getHotel().getHotelId();
        this.guestName = hotelFacilityUsage.getGuestName();
        this.facilityId = hotelFacilityUsage.getFacility().getFacilityId();
        this.usageDate = hotelFacilityUsage.getUsageDate();
        this.usageTime = hotelFacilityUsage.getUsageTime();
    }
}
