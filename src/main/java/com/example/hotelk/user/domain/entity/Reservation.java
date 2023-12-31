package com.example.hotelk.user.domain.entity;

import com.example.hotelk.room.domain.entity.Room;
import com.example.hotelk.user.domain.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    private String guestName;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Double totalPrice;

    @Column(nullable = false)
    private Integer people;
    private String poneNumber;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    // Getters and Setters
}
