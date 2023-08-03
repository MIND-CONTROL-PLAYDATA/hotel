package com.example.hotelk.room.domain.entity;

import com.example.hotelk.room.domain.requset.RoomFacilityRequest;
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
public class RoomFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long facilityId;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    private String name;
    private String description;
    private Integer num;

    public void update(RoomFacilityRequest request){
        this.name = request.getName();
        this.description = request.getDescription();
        this.num = request.getNum();
    }

    // Getters and Setters

}
