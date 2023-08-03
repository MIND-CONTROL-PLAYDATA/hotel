package com.example.hotelk.hotel.controller;

import com.example.hotelk.hotel.domain.request.HotelRegionRequest;
import com.example.hotelk.hotel.domain.request.HotelRoomRequest;
import com.example.hotelk.hotel.domain.response.HotelRegionResponse;
import com.example.hotelk.hotel.domain.response.HotelRoomResponse;
import com.example.hotelk.hotel.service.HotelRegionService;
import com.example.hotelk.hotel.service.HotelRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/hotel_room")
public class HotelRoomController {
    private final HotelRoomService hotelRoomService;

    @GetMapping
    public Page<HotelRoomResponse> findAll(
            @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page
    ) {
        PageRequest request = PageRequest.of(page, size);
        return hotelRoomService.getAll(request);
    }

    @PutMapping("{id}")
    public void update(@PathVariable("id") Long id, @RequestBody HotelRoomRequest request) {
        hotelRoomService.update(id, request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id) { hotelRoomService.delete(id);}

}
