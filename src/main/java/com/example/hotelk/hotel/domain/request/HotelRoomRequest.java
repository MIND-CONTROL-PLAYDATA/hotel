package com.example.hotelk.hotel.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HotelRoomRequest {
    private Long hotelId;
    private Long roomId;
}
