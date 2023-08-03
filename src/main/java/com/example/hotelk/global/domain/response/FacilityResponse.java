package com.example.hotelk.global.domain.response;

import com.example.hotelk.global.domain.entity.Facility;
import lombok.Getter;

@Getter
public class FacilityResponse {
    private Long facilityId;


    private String name;
    private String description;

    public FacilityResponse(Facility hotelFacility) {
        this.facilityId = hotelFacility.getFacilityId();
        this.name = hotelFacility.getName();
        this.description = hotelFacility.getDescription();
    }
}
