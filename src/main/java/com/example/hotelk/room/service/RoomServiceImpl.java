package com.example.hotelk.room.service;


import com.example.hotelk.hotel.domain.entity.Hotel;

import com.example.hotelk.hotel.domain.repository.HotelRepository;
import com.example.hotelk.room.domain.entity.Room;
import com.example.hotelk.room.domain.requset.RoomRequest;
import com.example.hotelk.room.domain.requset.UpdateRequest;
import com.example.hotelk.room.domain.response.RoomResponse;
import com.example.hotelk.room.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;
    @Override
    public void insert(Long hotelId, RoomRequest request) {
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow();
        roomRepository.save(request.toEntity(hotel,request));
    }

    @Override
    public void delete(Long id) {
        roomRepository.delete(findById(id));
    }

    @Override
    public Room findById(Long id) {
        return roomRepository.findById(id).orElseThrow();   //예외처리하기
    }

    @Override
    public void update(Long id, UpdateRequest request) {
        Room room = roomRepository.findById(id).orElseThrow();
        room.update(request);
//        roomRepository.save(update);

    }

    @Override
    public List<RoomResponse> findByName(String name) {
        List<Room> byNameContaining = roomRepository.findByNameContaining(name);
        return byNameContaining.stream()
                .map(RoomResponse::new)
                .toList();

    }

    @Override
    public List<RoomResponse> findAll(Long hotelId) {
        List<Room> allBy5 = roomRepository.findAllBy5(hotelId);
        return allBy5.stream()
                .map(RoomResponse::new)
                .toList();
    }
}
