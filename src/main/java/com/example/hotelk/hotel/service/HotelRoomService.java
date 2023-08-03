package com.example.hotelk.hotel.service;

import com.example.hotelk.config.exception.HotelNotFoundException;
import com.example.hotelk.config.exception.PromotionNotFoundException;
import com.example.hotelk.config.exception.RegionNotFoundException;
import com.example.hotelk.config.exception.RoomNotFoundException;
import com.example.hotelk.global.domain.entity.Promotion;
import com.example.hotelk.global.repository.PromotionRepository;
import com.example.hotelk.hotel.domain.entity.Hotel;
import com.example.hotelk.hotel.domain.entity.HotelPromotion;
import com.example.hotelk.hotel.domain.entity.HotelRoom;
import com.example.hotelk.hotel.domain.request.HotelPromotionRequest;
import com.example.hotelk.hotel.domain.request.HotelRoomRequest;
import com.example.hotelk.hotel.domain.response.HotelPromotionResponse;
import com.example.hotelk.hotel.domain.response.HotelRoomResponse;
import com.example.hotelk.hotel.repository.HotelPromotionRepository;
import com.example.hotelk.hotel.repository.HotelRepository;
import com.example.hotelk.hotel.repository.HotelRoomRepository;
import com.example.hotelk.room.domain.entity.Room;
import com.example.hotelk.room.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class HotelRoomService {
    private final HotelRoomRepository hotelRoomRepository;
    private final HotelRepository hotelRepository;
    private  final RoomRepository roomRepository;

    public Page<HotelRoomResponse> getAll(PageRequest request) {

        Page<HotelRoom> all = hotelRoomRepository.findAll(request);
        return all.map(HotelRoomResponse::new);
    }


    @Transactional
    public HotelRoomResponse update(Long id, HotelRoomRequest request) {
        Optional<HotelRoom> byId = hotelRoomRepository.findById(id);
        if (byId.isEmpty()) throw new RoomNotFoundException("Room NOT FOUND!!");

        Optional<Hotel> byId1 = hotelRepository.findById(request.hotelId());
        Optional<Room> byId2 = roomRepository.findById(request.rommId());

        Hotel hotel = byId1.orElseThrow(() -> new HotelNotFoundException("HOTEL NOT FOUND!!"));
        Room room = byId2.orElseThrow(() -> new RoomNotFoundException("Room NOT FOUND!!"));

        HotelRoom hotelRoom = new HotelRoom(id, hotel, room);
        HotelRoom save = hotelRoomRepository.save(hotelRoom);

        return new HotelRoomResponse(save);
    }

    public void delete(Long id) {
        hotelRoomRepository.deleteById(id);
    }



}
