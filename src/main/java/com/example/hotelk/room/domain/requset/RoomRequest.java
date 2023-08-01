package com.example.hotelk.room.domain.requset;

import com.example.hotelk.room.domain.entity.Room;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomRequest {
    private String name;
    private String type;
    private Double price;
    private Integer capacity;
    private String description;

    public Room toEntity(RoomRequest request){
        return Room.builder()
                .roomId(null)
                .hotel(null)
                .name(request.getName())
                .type(request.getType())
                .price(request.getPrice())
                .capacity(request.getCapacity())
                .description(request.getDescription())
                .build();
    }
}
