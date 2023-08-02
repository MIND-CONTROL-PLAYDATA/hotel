package com.example.hotelk.reservation.domain.response;

import com.example.hotelk.reservation.domain.entity.Reservation;
import com.example.hotelk.room.domain.entity.Room;
import com.example.hotelk.user.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReservationResponse {
    private Long reservationId;
    private String guestName;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Double totalPrice;
    private User userId;
    private Integer people;
    private String poneNumber;

    public ReservationResponse(Reservation reservation) {
        this.reservationId = reservation.getReservationId();
        this.guestName = reservation.getGuestName();
        this.checkInDate = reservation.getCheckInDate();
        this.checkOutDate = reservation.getCheckOutDate();
        this.totalPrice = reservation.getTotalPrice();
        this.userId = reservation.getUser();
        this.people = reservation.getPeople();
        this.poneNumber = reservation.getPoneNumber();
    }
}
