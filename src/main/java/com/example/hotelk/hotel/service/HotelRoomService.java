package com.example.hotelk.hotel.service;

import com.example.hotelk.hotel.repository.HotelRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class HotelRoomService {
    private final HotelRoomRepository hotelRoomRepository;


}
