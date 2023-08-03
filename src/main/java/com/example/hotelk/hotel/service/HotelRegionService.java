package com.example.hotelk.hotel.service;

import com.example.hotelk.hotel.domain.entity.Hotel;
import com.example.hotelk.hotel.repository.HotelRepository;
import com.example.hotelk.hotel.domain.entity.HotelRegion;
import com.example.hotelk.hotel.domain.request.HotelRegionRequest;
import com.example.hotelk.hotel.domain.response.HotelRegionResponse;
import com.example.hotelk.hotel.repository.HotelRegionRepository;
import com.example.hotelk.global.domain.entity.Region;
import com.example.hotelk.global.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HotelRegionService {

    private final HotelRegionRepository hotelRegionRepository;
    private final HotelRepository hotelRepository;
    private  final RegionRepository regionRepository;




    @Transactional
    public HotelRegionResponse update(Long id, HotelRegionRequest request) {
        Optional<HotelRegion> byId = hotelRegionRepository.findById(id);
        if (byId.isEmpty()) throw new RuntimeException("REGION NOT FOUND!!");

        Optional<Hotel> byId1 = hotelRepository.findById(request.hotelId());
        Optional<Region> byId2 = regionRepository.findById(request.regionId());

        Hotel hotel = byId1.orElseThrow(() -> new RuntimeException("HOTEL NOT FOUND!!"));
        Region region = byId2.orElseThrow(() -> new RuntimeException("REGION NOT FOUND!!"));

        HotelRegion hotelRegion = new HotelRegion(id, hotel, region);
        HotelRegion save = hotelRegionRepository.save(hotelRegion);

        return new HotelRegionResponse(save);
    }

    public void delete(Long id) {
        hotelRegionRepository.deleteById(id);
    }
}
