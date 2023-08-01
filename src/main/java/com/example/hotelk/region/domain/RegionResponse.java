package com.example.hotelk.region.domain;

import com.example.hotelk.region.domain.entity.Region;
import lombok.Getter;

@Getter
public class RegionResponse {

    private Long regionId;
    private String name;

    public RegionResponse(Region region) {
        this.regionId = region.getRegionId();
        this.name = region.getName();
    }
}
