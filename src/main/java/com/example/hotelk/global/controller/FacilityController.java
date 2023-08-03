package com.example.hotelk.global.controller;


import com.example.hotelk.global.domain.request.FacilityRequest;
import com.example.hotelk.global.domain.response.FacilityResponse;
import com.example.hotelk.global.service.FacilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/hotelFacility")
public class FacilityController {

    private final FacilityService hotelFacilityService;

    @PostMapping
    public void insert(@RequestBody FacilityRequest request) {
        hotelFacilityService.insert(request);
    }

    @GetMapping
    public Page<FacilityResponse> findAll(
            @RequestParam(value = "name", required = false, defaultValue = "") String name,
            @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page
    ) {
        PageRequest request = PageRequest.of(page, size);
        return hotelFacilityService.getAll(name, request);
    }


    @PutMapping("{id}")
    public void update(@PathVariable("id") Long id, @RequestBody FacilityRequest request) {
        hotelFacilityService.update(id, request);
    }


    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id) {
        hotelFacilityService.delete(id);
    }
}
