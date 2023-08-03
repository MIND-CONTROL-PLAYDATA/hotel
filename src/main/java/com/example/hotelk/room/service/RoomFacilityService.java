package com.example.hotelk.room.service;

import com.example.hotelk.room.domain.requset.RoomFacilityRequest;
import com.example.hotelk.room.domain.response.RoomFacilityResponse;

import java.util.List;

public interface RoomFacilityService {
    void save(Long roomId,RoomFacilityRequest request);
    RoomFacilityResponse findByName(Long roomId, String name);
    void delete(Long roomId,String name);
    void update(Long roomId, String name, RoomFacilityRequest request);
    List<RoomFacilityResponse> findAll(Long roomId);
}
