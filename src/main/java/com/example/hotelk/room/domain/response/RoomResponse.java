package com.example.hotelk.room.domain.response;

import com.example.hotelk.room.domain.entity.Room;
import lombok.Getter;

@Getter
public class RoomResponse {
    private String name;
    private String type;
    private Double price;
    private Integer capacity;
    private String description;
    private String hotelName;

    public RoomResponse(Room room){
        this.name = room.getName();
        this.type = room.getType();
        this.price = room.getPrice();
        this.capacity = room.getCapacity();
        this.description = room.getDescription();
        this.hotelName = room.getHotel().getName();
    }
}
