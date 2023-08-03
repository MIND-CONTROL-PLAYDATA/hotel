package com.example.hotelk.hotel.controller;

import com.example.hotelk.hotel.domain.request.HotelPromotionRequest;
import com.example.hotelk.hotel.domain.request.HotelRegionRequest;
import com.example.hotelk.hotel.domain.response.HotelPromotionResponse;
import com.example.hotelk.hotel.domain.response.HotelRegionResponse;
import com.example.hotelk.hotel.service.HotelPromotionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/hotel_promotion")
public class HotelPromotionController {
    private final HotelPromotionService hotelPromotionService;
    @GetMapping
    public Page<HotelPromotionResponse> findAll(
            @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page
    ) {
        PageRequest request = PageRequest.of(page, size);
        return hotelPromotionService.getAll(request);
    }

    @PutMapping("{id}")
    public void update(@PathVariable("id") Long id, @RequestBody HotelPromotionRequest request) {
        hotelPromotionService.update(id, request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id) { hotelPromotionService.delete(id);}

}
