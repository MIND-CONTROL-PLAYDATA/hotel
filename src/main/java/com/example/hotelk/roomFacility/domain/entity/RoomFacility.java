package com.example.hotelk.roomFacility.domain.entity;

import com.example.hotelk.room.domain.entity.Room;
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

    // Getters and Setters
}
