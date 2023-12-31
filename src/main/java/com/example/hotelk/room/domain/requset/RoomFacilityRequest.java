package com.example.hotelk.room.domain.requset;

import com.example.hotelk.room.domain.entity.Room;
import com.example.hotelk.room.domain.entity.RoomFacility;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter @AllArgsConstructor
@NoArgsConstructor
public class RoomFacilityRequest {
    private String name;
    private String description;
    private Integer num;

    public RoomFacility toEntity(RoomFacilityRequest request,Room room){
        return RoomFacility.builder()
                .facilityId(null)
                .room(room)
                .name(request.getName())
                .num(request.getNum())
                .description(request.getDescription())
                .build();
    }

}
