package com.example.hotelk.hotelRegion.controller;


import com.example.hotelk.hotelRegion.domain.request.ConnectRequest;
import com.example.hotelk.hotelRegion.domain.response.HotelRegionResponse;
import com.example.hotelk.hotelRegion.service.HotelRegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/hotel_region")
public class HotelRegionController {

    private final HotelRegionService hotelRegionService;

    @PostMapping
    public void connect(@RequestBody ConnectRequest request) {
        hotelRegionService.connect(request);
    }

    @GetMapping
    public Page<HotelRegionResponse> findAll(
            @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page
    ) {
        PageRequest request = PageRequest.of(page, size);
        return hotelRegionService.getAll(request);
    }

    @PutMapping("{id}")
    public void update(@PathVariable("id") Long id, @RequestBody ConnectRequest request) {
        hotelRegionService.update(id, request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id) { hotelRegionService.delete(id);}

}
