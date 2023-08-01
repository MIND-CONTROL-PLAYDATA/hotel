package com.example.hotelk.hotelFacilityUsage.service;


import com.example.hotelk.hotelFacilityUsage.domain.entity.HotelFacilityUsage;
import com.example.hotelk.hotelFacilityUsage.domain.request.HotelFacilityUsageRequest;
import com.example.hotelk.hotelFacilityUsage.repository.HotelFacilityUsageRepository;
import com.example.hotelk.hotelFacilityUsage.response.HotelFacilityUsageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HotelFacilityUsageService {

    private final HotelFacilityUsageRepository hotelFacilityUsageRepository;

    public void insert(HotelFacilityUsageRequest request) {
        hotelFacilityUsageRepository.save(request.toEntity());
    }

    public Page<HotelFacilityUsageResponse> getAll(PageRequest request) {
        Page<HotelFacilityUsage> all = hotelFacilityUsageRepository.findAll(request);

        return all.map(HotelFacilityUsageResponse::new);
    }

    public HotelFacilityUsageResponse update(Long id, HotelFacilityUsageRequest request) {
        Optional<HotelFacilityUsage> byId = hotelFacilityUsageRepository.findById(id);
        HotelFacilityUsage hotelFacilityUsage = byId.orElseThrow(() -> new RuntimeException("NOT FOUND!!"));

        HotelFacilityUsage save = hotelFacilityUsageRepository.save(hotelFacilityUsage);

        return new HotelFacilityUsageResponse(save);
    }

    public void delete(Long id) {
        hotelFacilityUsageRepository.deleteById(id);
    }
}
