package com.example.hotelk.reservation.domain.request;

import com.example.hotelk.reservation.domain.entity.Reservation;
import com.example.hotelk.room.domain.entity.Room;
import com.example.hotelk.user.domain.entity.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class ReservationRequest {
    private Room roomId;
    private String guestName;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Long totalPrice;
    private User userId;
    private Integer people;
    private Boolean payment;
    private String poneNumber;

    public Reservation toEntity() {
        return Reservation.builder()
                .room(roomId)
                .guestName(guestName)
                .checkInDate(checkInDate)
                .checkOutDate(checkOutDate)
                .totalPrice(totalPrice)
                .user(userId)
                .people(people)
                .payment(payment)
                .poneNumber(poneNumber)
                .build();
    }
}
