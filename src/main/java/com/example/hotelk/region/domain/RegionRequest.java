package com.example.hotelk.region.domain;

import com.example.hotelk.region.domain.entity.Region;

public record RegionRequest(String name) {

    public Region toEntity() {
        return Region.builder().name(name).build();
    }
}
