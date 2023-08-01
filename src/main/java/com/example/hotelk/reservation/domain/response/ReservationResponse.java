package com.example.hotelk.reservation.domain.response;

import com.example.hotelk.reservation.domain.entity.Reservation;
import com.example.hotelk.room.domain.entity.Room;
import com.example.hotelk.user.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReservationResponse {
    private Room roomId;
    private String guestName;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Long totalPrice;
    private User userId;
    private Integer people;
    private Boolean payment;
    private String poneNumber;

    public ReservationResponse(Reservation reservation) {
        this.roomId = reservation.getRoom();
        this.guestName = reservation.getGuestName();
        this.checkInDate = reservation.getCheckInDate();
        this.checkOutDate = reservation.getCheckOutDate();
        this.totalPrice = reservation.getTotalPrice();
        this.userId = reservation.getUser();
        this.people = reservation.getPeople();
        this.payment = reservation.getPayment();
        this.poneNumber = reservation.getPoneNumber();
    }
}
