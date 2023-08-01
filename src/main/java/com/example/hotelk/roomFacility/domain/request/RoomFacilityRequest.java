package com.example.hotelk.roomFacility.domain.request;

import com.example.hotelk.room.domain.entity.Room;
import com.example.hotelk.roomFacility.domain.entity.RoomFacility;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter @AllArgsConstructor
@NoArgsConstructor
public class RoomFacilityRequest {
    private String name;
    private String description;
    private Integer num;

    public RoomFacility toEntity(RoomFacilityRequest request){
        return RoomFacility.builder()
                .facilityId(null)
                .room(null)
                .name(request.getName())
                .num(request.getNum())
                .description(request.getDescription())
                .build();
    }

}
