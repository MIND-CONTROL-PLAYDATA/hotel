package com.example.hotelk.roomFacility.serivce;

import com.example.hotelk.roomFacility.domain.entity.RoomFacility;
import com.example.hotelk.roomFacility.domain.request.RoomFacilityRequest;

import java.util.List;

public interface RoomFacilityService {
    void save(RoomFacilityRequest request);
    RoomFacility findByName(String name);
    void delete(String name);
    void update(String name, RoomFacilityRequest request);
    List<RoomFacility> findAll();
}
