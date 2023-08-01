package com.example.hotelk.room.service;

import com.example.hotelk.room.domain.entity.Room;
import com.example.hotelk.room.domain.requset.RoomRequest;
import com.example.hotelk.room.domain.requset.UpdateRequest;
import org.hibernate.sql.Update;

import java.util.List;

public interface RoomService {

    void insert(RoomRequest request);
    void delete(Long id);
    Room findById(Long id);
    void update(Long id, UpdateRequest request);
    List<Room> findByName(String name);
    List<Room> findAll();
}
