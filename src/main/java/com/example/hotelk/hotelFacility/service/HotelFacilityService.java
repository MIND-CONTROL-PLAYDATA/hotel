package com.example.hotelk.hotelFacility.service;

import com.example.hotelk.hotelFacility.domain.entity.HotelFacility;
import com.example.hotelk.hotelFacility.domain.request.HotelFacilityRequest;
import com.example.hotelk.hotelFacility.domain.response.HotelFacilityResponse;
import com.example.hotelk.hotelFacility.repository.HotelFacilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HotelFacilityService {

    private final HotelFacilityRepository hotelFacilityRepository;

    public void insert(HotelFacilityRequest request) {
        hotelFacilityRepository.save(request.toEntity());
    }

    public Page<HotelFacilityResponse> getAll(String name, PageRequest request) {
        Page<HotelFacility> all = hotelFacilityRepository.findAllByNameContaining(name, request);
        return all.map(HotelFacilityResponse::new);
    }

    public HotelFacilityResponse update(Long id, HotelFacilityRequest request) {
        Optional<HotelFacility> byId = hotelFacilityRepository.findById(id);
        HotelFacility hotelFacility = byId.orElseThrow(() -> new RuntimeException("HOTEL FACILITY NOT FOUND!!"));
        HotelFacility save = hotelFacilityRepository.save(hotelFacility);

        return new HotelFacilityResponse(save);
    }

    public void delete(Long id) {
        hotelFacilityRepository.deleteById(id);
    }
}
