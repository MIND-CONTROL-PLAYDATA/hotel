package com.example.hotelk.room.service;

import com.example.hotelk.room.domain.entity.Room;
import com.example.hotelk.room.domain.requset.RoomRequest;
import com.example.hotelk.room.domain.requset.UpdateRequest;
import com.example.hotelk.room.domain.response.RoomResponse;
import org.hibernate.sql.Update;

import java.util.List;

public interface RoomService {

    void insert(Long hotelId, RoomRequest request);

    void delete(Long id);

    Room findById(Long hotelId);

    void update(Long id, UpdateRequest request);

    List<RoomResponse> findByName(String name);

    List<RoomResponse> findAll(Long hotelId);
}
