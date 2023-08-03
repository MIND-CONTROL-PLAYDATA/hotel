package com.example.hotelk.hotel.service;

import com.example.hotelk.hotel.repository.HotelPromotionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class HotelPromotionService {
    private final HotelPromotionRepository hotelPromotionRepository;


}
