package com.example.hotelk.global.controller;

import com.example.hotelk.global.domain.request.FacilityUsageRequest;
import com.example.hotelk.global.domain.response.FacilityUsageResponse;
import com.example.hotelk.global.service.FacilityUsageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/hotelFacilityUsage")
public class FacilityUsageController {

    private final FacilityUsageService hotelFacilityUsageService;
    @PostMapping
    public void insert(@RequestBody FacilityUsageRequest request) {
        hotelFacilityUsageService.insert(request);
    }

    @GetMapping
    public Page<FacilityUsageResponse> findAll(
            @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page
    ) {
        PageRequest request = PageRequest.of(page, size);
        return hotelFacilityUsageService.getAll(request);
    }


    @PutMapping("{id}")
    public void update(@PathVariable("id") Long id, @RequestBody FacilityUsageRequest request) {
        hotelFacilityUsageService.update(id, request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id) {
        hotelFacilityUsageService.delete(id);
    }

}
