package com.example.hotelk.global.domain.request;

import java.time.LocalDate;
import java.time.LocalTime;

public record FacilityUsageRequest(Long hotelId, String guestName, Long facilityId,
                                   LocalDate usageDate, LocalTime usageTime) {


}
