package com.example.hotelk.hotel.controller;

import com.example.hotelk.hotel.domain.request.HotelRegionRequest;
import com.example.hotelk.hotel.domain.response.HotelFacilityResponse;
import com.example.hotelk.hotel.domain.response.HotelRegionResponse;
import com.example.hotelk.hotel.service.HotelFacilityService;
import com.example.hotelk.hotel.service.HotelRegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/hotel_facility")
public class HotelFacilityController {
    private final HotelFacilityService hotelFacilityService;

    @GetMapping
    public Page<HotelFacilityResponse> findAll(
            @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page
    ) {
        PageRequest request = PageRequest.of(page, size);
        return hotelFacilityService.getAll(request);
    }

    @PutMapping("{id}")
    public void update(@PathVariable("id") Long id, @RequestBody HotelRegionRequest request) {
        hotelFacilityService.update(id, request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id) { hotelFacilityService.delete(id);}
}
