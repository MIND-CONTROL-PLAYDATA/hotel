package com.example.hotelk.reservation.domain.response;

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
}
