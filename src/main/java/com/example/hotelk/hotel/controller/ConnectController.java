package com.example.hotelk.hotel.controller;

import com.example.hotelk.hotel.domain.request.HotelPromotionRequest;
import com.example.hotelk.hotel.service.HotelPromotionService;
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

    @PostMapping("/hotelpromotion") // /는 자동적으로 붙어서 없어도 된다
    public void hpconnect(@RequestBody HotelPromotionRequest hotelPromotionRequest) {
        hotelPromotionService.hpconnect(hotelPromotionRequest);
    }
}
