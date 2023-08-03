package com.example.hotelk.hotel.service;

import com.example.hotelk.config.exception.HotelFacilityNotFoundException;
import com.example.hotelk.config.exception.HotelNotFoundException;
import com.example.hotelk.config.exception.RegionNotFoundException;
import com.example.hotelk.global.domain.entity.Facility;
import com.example.hotelk.global.domain.entity.Region;
import com.example.hotelk.global.repository.FacilityRepository;
import com.example.hotelk.hotel.domain.entity.Hotel;
import com.example.hotelk.hotel.domain.entity.HotelFacility;
import com.example.hotelk.hotel.domain.entity.HotelRegion;
import com.example.hotelk.hotel.domain.request.HotelRegionRequest;
import com.example.hotelk.hotel.domain.response.HotelFacilityResponse;
import com.example.hotelk.hotel.domain.response.HotelRegionResponse;
import com.example.hotelk.hotel.repository.HotelFacilityRepository;
import com.example.hotelk.hotel.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HotelFacilityService {

    private final HotelFacilityRepository hotelFacilityRepository;

    private final HotelRepository hotelRepository;
    private final FacilityRepository facilityRepository;
    public Page<HotelFacilityResponse> getAll(PageRequest request) {

        Page<HotelFacility> all = hotelFacilityRepository.findAll(request);
        return all.map(HotelFacilityResponse::new);
    }


    @Transactional
    public HotelFacilityResponse update(Long id, HotelRegionRequest request) {
        Optional<HotelFacility> byId = hotelFacilityRepository.findById(id);
        if (byId.isEmpty()) throw new HotelFacilityNotFoundException(" HotelFacility NOT FOUND!!");

        Optional<Hotel> byId1 = hotelRepository.findById(request.hotelId());
        Optional<Facility> byId2 = facilityRepository.findById(request.regionId());

        Hotel hotel = byId1.orElseThrow(() -> new HotelNotFoundException("HOTEL NOT FOUND!!"));
        Facility facility = byId2.orElseThrow(() -> new RegionNotFoundException("Facility NOT FOUND!!"));

        HotelFacility hotelFacility = new HotelFacility(id, hotel, facility);
        HotelFacility save = hotelFacilityRepository.save(hotelFacility);

        return new HotelFacilityResponse(save);
    }

    public void delete(Long id) {
        hotelFacilityRepository.deleteById(id);
    }
}
