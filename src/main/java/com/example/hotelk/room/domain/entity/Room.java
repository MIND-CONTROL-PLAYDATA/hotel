package com.example.hotelk.room.domain.entity;

import com.example.hotelk.hotel.domain.entity.Hotel;
import com.example.hotelk.room.domain.requset.UpdateRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    private String name;
    private String type;
    private Double price;
    private Integer capacity;
    private String description;

    public Room update (UpdateRequest request){
        if(request.getName() != null){
            this.name = request.getName();
        }
        if(request.getType() != null){
            this.type = request.getType();
        }
        if(request.getPrice() != null){
            this.price = request.getPrice();
        }
        if(request.getCapacity() != null){
            this.capacity = request.getCapacity();
        }
        if(request.getDescription() != null){
            this.description = request.getDescription();
        }
        return Room;
    }
}
