package com.example.hotelk.amenities.controller;


import com.example.hotelk.amenities.domain.request.AmenitiesRequest;
import com.example.hotelk.amenities.domain.response.AmenitiesResponse;
import com.example.hotelk.amenities.service.AmenitiesService;
import com.example.hotelk.region.domain.RegionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/amenities")
public class AmenitiesController {

    private final AmenitiesService amenitiesService;

    @PostMapping
    public void insert(@RequestBody AmenitiesRequest request) {
        amenitiesService.insert(request);
    }

    @GetMapping
    public Page<AmenitiesResponse> findAll(
            @RequestParam(value = "name", required = false, defaultValue = "") String name,
            @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page
    ) {
        PageRequest request = PageRequest.of(page, size);
        return amenitiesService.getAll(name, request);
    }

    @PutMapping("{id}")
    public void update(@PathVariable("id") Long id, @RequestBody AmenitiesRequest request) {
        amenitiesService.update(id, request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id) {
        amenitiesService.delete(id);
    }
}
