package com.example.hotelk.roomFacility.serivce;

import com.example.hotelk.roomFacility.domain.entity.RoomFacility;
import com.example.hotelk.roomFacility.domain.request.RoomFacilityRequest;
import com.example.hotelk.roomFacility.domain.response.RoomFacilityResponse;

import java.util.List;

public interface RoomFacilityService {
    void save(Long roomId,RoomFacilityRequest request);
    RoomFacilityResponse findByName(Long roomId, String name);
    void delete(Long roomId,String name);
    void update(Long roomId, String name, RoomFacilityRequest request);
    List<RoomFacilityResponse> findAll(Long roomId);
}
