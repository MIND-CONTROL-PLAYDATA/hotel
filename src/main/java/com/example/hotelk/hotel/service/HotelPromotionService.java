package com.example.hotelk.hotel.service;

import com.example.hotelk.hotel.domain.entity.Hotel;
import com.example.hotelk.hotel.domain.entity.HotelPromotion;
import com.example.hotelk.hotel.domain.entity.Promotion;
import com.example.hotelk.hotel.domain.repository.HotelPromotionRepository;
import com.example.hotelk.hotel.domain.request.HotelPromotionRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class HotelPromotionService {
    private final HotelPromotionRepository hotelPromotionRepository;

    public void hpconnect(HotelPromotionRequest hotelPromotionRequest) {
        HotelPromotion hotelPromotion = new HotelPromotion(null, Hotel
                .builder()
                .hotelId(hotelPromotionRequest.getHotelId())
                .build(),

                Promotion
                .builder()
                .promotionId(hotelPromotionRequest.getPromotionId())
                .build());
        hotelPromotionRepository.save(hotelPromotion);
        //builder랑 new랑 똑같다고 보면 된다
    }
}
