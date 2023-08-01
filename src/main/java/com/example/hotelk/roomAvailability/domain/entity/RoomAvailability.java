package com.example.hotelk.roomAvailability.domain.entity;

import com.example.hotelk.room.domain.entity.Room;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

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

    @Column(columnDefinition = "boolean default true")
    private boolean availableCount;

    // Getters and Setters
}
