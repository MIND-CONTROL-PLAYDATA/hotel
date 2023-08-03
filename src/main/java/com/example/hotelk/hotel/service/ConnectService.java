package com.example.hotelk.hotel.service;

import com.example.hotelk.global.domain.entity.Promotion;
import com.example.hotelk.hotel.domain.entity.*;
import com.example.hotelk.hotel.repository.HotelPromotionRepository;
import com.example.hotelk.hotel.repository.HotelRegionRepository;
import com.example.hotelk.hotel.repository.HotelRoomRepository;
import com.example.hotelk.hotel.domain.request.HotelPromotionRequest;
import com.example.hotelk.hotel.domain.request.HotelRegionRequest;
import com.example.hotelk.hotel.domain.request.HotelRoomRequest;
import com.example.hotelk.global.domain.entity.Region;
import com.example.hotelk.room.domain.entity.Room;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class ConnectService {

    private final HotelPromotionRepository hotelPromotionRepository;
    private final HotelRoomRepository hotelRoomRepository;
    private final HotelRegionRepository hotelRegionRepository;

    public void hpconnect(HotelPromotionRequest hotelPromotionRequest) {

        HotelPromotion hotelPromotion = new HotelPromotion(null,
                Hotel
                .builder()
                .hotelId(hotelPromotionRequest.hotelId())
                .build(),

                Promotion
                        .builder()
                        .promotionId(hotelPromotionRequest.promotionId())
                        .build());
        hotelPromotionRepository.save(hotelPromotion);
    }

    @Transactional
    public void hregionconnect(HotelRegionRequest request) {
        HotelRegion hotelRegion = new HotelRegion(null,
                Hotel
                        .builder()
                        .hotelId(request.hotelId())
                        .build(),

                Region
                        .builder()
                        .regionId(request.regionId())
                        .build()
        );
        hotelRegionRepository.save(hotelRegion);

    }

    public void hrconnect(HotelRoomRequest hotelRoomRequest) {
        HotelRoom hotelRoom = new HotelRoom(null, Hotel
                .builder()
                .hotelId(hotelRoomRequest.hotelId())
                .build(),

                Room
                        .builder()
                        .roomId(hotelRoomRequest.rommId())
                        .build());
        hotelRoomRepository.save(hotelRoom);
    }

}
