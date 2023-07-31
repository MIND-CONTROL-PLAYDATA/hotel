package com.example.hotelk.roomAvailability.domain.entity;

import com.example.hotelk.room.domain.entity.Room;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class RoomAvailability {
    @Id
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @Id
    private Timestamp date;

    private int availableCount;

    // Getters and Setters
}
