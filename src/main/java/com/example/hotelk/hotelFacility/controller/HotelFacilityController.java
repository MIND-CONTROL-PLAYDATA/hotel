package com.example.hotelk.hotelFacility.controller;


import com.example.hotelk.hotelFacility.domain.request.HotelFacilityRequest;
import com.example.hotelk.hotelFacility.domain.response.HotelFacilityResponse;
import com.example.hotelk.hotelFacility.service.HotelFacilityService;
import com.example.hotelk.region.domain.RegionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/hotelFacility")
public class HotelFacilityController {

    private final HotelFacilityService hotelFacilityService;

    @PostMapping
    public void insert(@RequestBody HotelFacilityRequest request) {
        hotelFacilityService.insert(request);
    }

    @GetMapping
    public Page<HotelFacilityResponse> findAll(
            @RequestParam(value = "name", required = false, defaultValue = "") String name,
            @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page
    ) {
        PageRequest request = PageRequest.of(page, size);
        return hotelFacilityService.getAll(name, request);
    }


    @PutMapping("{id}")
    public void update(@PathVariable("id") Long id, @RequestBody HotelFacilityRequest request) {
        hotelFacilityService.update(id, request);
    }


    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id) {
        hotelFacilityService.delete(id);
    }
}
