package com.example.hotelk.hotel.service;

import com.example.hotelk.config.exception.HotelNotFoundException;
import com.example.hotelk.config.exception.PromotionNotFoundException;
import com.example.hotelk.config.exception.RegionNotFoundException;
import com.example.hotelk.global.domain.entity.Promotion;
import com.example.hotelk.global.domain.entity.Region;
import com.example.hotelk.global.repository.PromotionRepository;
import com.example.hotelk.global.repository.RegionRepository;
import com.example.hotelk.hotel.domain.entity.Hotel;
import com.example.hotelk.hotel.domain.entity.HotelPromotion;
import com.example.hotelk.hotel.domain.entity.HotelRegion;
import com.example.hotelk.hotel.domain.request.HotelPromotionRequest;
import com.example.hotelk.hotel.domain.request.HotelRegionRequest;
import com.example.hotelk.hotel.domain.response.HotelPromotionResponse;
import com.example.hotelk.hotel.domain.response.HotelRegionResponse;
import com.example.hotelk.hotel.repository.HotelPromotionRepository;
import com.example.hotelk.hotel.repository.HotelRegionRepository;
import com.example.hotelk.hotel.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class HotelPromotionService {
    private final HotelPromotionRepository hotelPromotionRepository;
    private final HotelRepository hotelRepository;
    private  final PromotionRepository promotionRepository;

    public Page<HotelPromotionResponse> getAll(PageRequest request) {

        Page<HotelPromotion> all = hotelPromotionRepository.findAll(request);
        return all.map(HotelPromotionResponse::new);
    }


    @Transactional
    public HotelPromotionResponse update(Long id, HotelPromotionRequest request) {
        Optional<HotelPromotion> byId = hotelPromotionRepository.findById(id);
        if (byId.isEmpty()) throw new PromotionNotFoundException("Promotion NOT FOUND!!");

        Optional<Hotel> byId1 = hotelRepository.findById(request.hotelId());
        Optional<Promotion> byId2 = promotionRepository.findById(request.promotionId());

        Hotel hotel = byId1.orElseThrow(() -> new HotelNotFoundException("HOTEL NOT FOUND!!"));
        Promotion promotion = byId2.orElseThrow(() -> new RegionNotFoundException("Promotion NOT FOUND!!"));

        HotelPromotion hotelPromotion = new HotelPromotion(id, hotel, promotion);
        HotelPromotion save = hotelPromotionRepository.save(hotelPromotion);

        return new HotelPromotionResponse(save);
    }

    public void delete(Long id) {
        hotelPromotionRepository.deleteById(id);
    }

}
