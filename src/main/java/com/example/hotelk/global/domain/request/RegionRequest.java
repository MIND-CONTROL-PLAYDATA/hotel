package com.example.hotelk.global.domain.request;

import com.example.hotelk.global.domain.entity.Region;

public record RegionRequest(String name) {

    public Region toEntity() {
        return Region.builder().name(name).build();
    }
}
