package com.example.hotelk.hotel.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public class HotelPromotionRequest {
    private Long hotelId;
    private Long promotionId;
}
