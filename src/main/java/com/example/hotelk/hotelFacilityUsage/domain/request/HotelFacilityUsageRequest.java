package com.example.hotelk.hotelFacilityUsage.domain.request;

import com.example.hotelk.hotel.domain.entity.Hotel;
import com.example.hotelk.hotelFacility.domain.entity.HotelFacility;
import com.example.hotelk.hotelFacilityUsage.domain.entity.HotelFacilityUsage;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;

public record HotelFacilityUsageRequest(Long hotelId, String guestName, Long facilityId,
                                        LocalDate usageDate, LocalTime usageTime) {


}
