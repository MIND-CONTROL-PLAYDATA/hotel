package com.example.hotelk.roomFacility.domain.response;

import com.example.hotelk.room.domain.entity.Room;
import com.example.hotelk.roomFacility.domain.entity.RoomFacility;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter @NoArgsConstructor
@AllArgsConstructor
public class RoomFacilityResponse {
    private Integer num;
    private String description;
    private String name;
    private Long facilityId;

    public RoomFacilityResponse(RoomFacility roomFacility) {
        this.num = roomFacility.getNum();
        this.description = roomFacility.getDescription();
        this.name = roomFacility.getName();
        this.facilityId = roomFacility.getFacilityId();
    }
}
