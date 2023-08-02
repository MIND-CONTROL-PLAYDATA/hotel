package com.example.hotelk.hotel.service;

import com.example.hotelk.hotel.domain.entity.Hotel;
import com.example.hotelk.hotel.domain.entity.HotelPromotion;
import com.example.hotelk.hotel.domain.entity.HotelRoom;
import com.example.hotelk.hotel.domain.entity.Promotion;
import com.example.hotelk.hotel.domain.repository.HotelRoomRepository;
import com.example.hotelk.hotel.domain.request.HotelPromotionRequest;
import com.example.hotelk.hotel.domain.request.HotelRoomRequest;
import com.example.hotelk.room.domain.entity.Room;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class HotelRoomService {
    private final HotelRoomRepository hotelRoomRepository;

    public void hrconnect(HotelRoomRequest hotelRoomRequest) {
        HotelRoom hotelRoom = new HotelRoom(null, Hotel
                .builder()
                .hotelId(hotelRoomRequest.getHotelId())
                .build(),

                Room
                        .builder()
                        .roomId(hotelRoomRequest.getRoomId())
                        .build());
        hotelRoomRepository.save(hotelRoom);
    }
}
