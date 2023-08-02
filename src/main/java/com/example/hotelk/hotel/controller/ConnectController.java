package com.example.hotelk.hotel.controller;

import com.example.hotelk.hotel.domain.request.HotelPromotionRequest;
import com.example.hotelk.hotel.domain.request.HotelRegionRequest;
import com.example.hotelk.hotel.domain.request.HotelRoomRequest;
import com.example.hotelk.hotel.service.HotelPromotionService;
import com.example.hotelk.hotel.service.HotelRoomService;
import com.example.hotelk.hotel.service.HotelRegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/connect")
public class ConnectController {
    private final HotelPromotionService hotelPromotionService;
    private final HotelRoomService hotelRoomService;
    private final HotelRegionService hotelRegionService;

    @PostMapping("/hotelpromotion")
    public void hpconnect(@RequestBody HotelPromotionRequest hotelPromotionRequest) {
        hotelPromotionService.hpconnect(hotelPromotionRequest);
    }

    @PostMapping("/hotelroom")
    public void hrconnect(@RequestBody HotelRoomRequest hotelRoomRequest) {
        hotelRoomService.hrconnect(hotelRoomRequest);
    }
    @PostMapping("/hotelregion")
    public void hregionconnect(@RequestBody HotelRegionRequest hotelRegionRequest) {
        hotelRegionService.hregionconnect(hotelRegionRequest);
    }
}
