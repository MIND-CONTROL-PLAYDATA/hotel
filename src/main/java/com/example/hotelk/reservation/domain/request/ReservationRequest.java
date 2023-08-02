package com.example.hotelk.reservation.domain.request;

import com.example.hotelk.hotel.domain.entity.Hotel;
import com.example.hotelk.reservation.domain.entity.Reservation;
import com.example.hotelk.room.domain.entity.Room;
import com.example.hotelk.user.domain.entity.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Getter
@AllArgsConstructor
public class ReservationRequest {
    private Long roomId;
    private String guestName;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Long userId;
    private Integer people;
    private String poneNumber;

    /*public Reservation toEntity(Room roomId, User userId) {
        double totalPrice = ChronoUnit.DAYS.between(checkInDate, checkOutDate) * roomId.getPrice(); //totalPrice 계산
        return Reservation.builder()
                .room(roomId)
                .guestName(guestName)
                .checkInDate(checkInDate)
                .checkOutDate(checkOutDate)
                .totalPrice(totalPrice)
                .people(people)
                .poneNumber(poneNumber)
                .user(userId)
                .build();
    }*/
}
