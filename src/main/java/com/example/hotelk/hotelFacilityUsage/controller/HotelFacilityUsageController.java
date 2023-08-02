package com.example.hotelk.hotelFacilityUsage.controller;

import com.example.hotelk.hotelFacilityUsage.domain.request.HotelFacilityUsageRequest;
import com.example.hotelk.hotelFacilityUsage.response.HotelFacilityUsageResponse;
import com.example.hotelk.hotelFacilityUsage.service.HotelFacilityUsageService;
import com.example.hotelk.region.domain.RegionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/hotelFacilityUsage")
public class HotelFacilityUsageController {

    private final HotelFacilityUsageService hotelFacilityUsageService;
    @PostMapping
    public void insert(@RequestBody HotelFacilityUsageRequest request) {
        hotelFacilityUsageService.insert(request);
    }

    @GetMapping
    public Page<HotelFacilityUsageResponse> findAll(
            @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page
    ) {
        PageRequest request = PageRequest.of(page, size);
        return hotelFacilityUsageService.getAll(request);
    }


    @PutMapping("{id}")
    public void update(@PathVariable("id") Long id, @RequestBody HotelFacilityUsageRequest request) {
        hotelFacilityUsageService.update(id, request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id) {
        hotelFacilityUsageService.delete(id);
    }

}
