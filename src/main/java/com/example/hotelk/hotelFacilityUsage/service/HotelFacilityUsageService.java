package com.example.hotelk.hotelFacilityUsage.service;


import com.example.hotelk.amenities.domain.entity.Amenities;
import com.example.hotelk.amenities.domain.request.AmenitiesRequest;
import com.example.hotelk.config.exception.HotelFacilityNotFoundException;
import com.example.hotelk.config.exception.HotelFacilityUsageNotFoundException;
import com.example.hotelk.config.exception.HotelNotFoundException;
import com.example.hotelk.hotel.domain.entity.Hotel;
import com.example.hotelk.hotel.domain.repository.HotelRepository;
import com.example.hotelk.hotelFacility.domain.entity.HotelFacility;
import com.example.hotelk.hotelFacility.repository.HotelFacilityRepository;
import com.example.hotelk.hotelFacilityUsage.domain.entity.HotelFacilityUsage;
import com.example.hotelk.hotelFacilityUsage.domain.request.HotelFacilityUsageRequest;
import com.example.hotelk.hotelFacilityUsage.repository.HotelFacilityUsageRepository;
import com.example.hotelk.hotelFacilityUsage.response.HotelFacilityUsageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class HotelFacilityUsageService {

    private final HotelFacilityUsageRepository hotelFacilityUsageRepository;
    private final HotelRepository hotelRepository;
    private final HotelFacilityRepository hotelFacilityRepository;

    public void insert(HotelFacilityUsageRequest request) {
        Long hotelId = request.hotelId();
        Long facilityId = request.facilityId();

        // Find the Hotel entity from the database based on the provided hotelId
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new HotelNotFoundException("Hotel not found"));

        HotelFacility hotelFacility = hotelFacilityRepository.findById(facilityId).orElseThrow(() -> new HotelFacilityNotFoundException("Facility not found"));

        // Create the HotelFacility entity with the fetched Hotel entity
        HotelFacilityUsage hotelFacilityUsage = HotelFacilityUsage.builder()
                .hotel(hotel).guestName(request.guestName()).facility(hotelFacility)
                .usageDate(request.usageDate()).usageTime(request.usageTime()).build();

        // Save the HotelFacility entity
        hotelFacilityUsageRepository.save(hotelFacilityUsage);
    }

    public Page<HotelFacilityUsageResponse> getAll(PageRequest request) {
        Page<HotelFacilityUsage> all = hotelFacilityUsageRepository.findAll(request);

        return all.map(HotelFacilityUsageResponse::new);
    }

    public HotelFacilityUsageResponse update(Long id, HotelFacilityUsageRequest request) {
        Optional<HotelFacilityUsage> byId = hotelFacilityUsageRepository.findById(id);
        if (byId.isEmpty()) throw new HotelFacilityUsageNotFoundException("Hotel Facility Usage NOT FOUND!!");

        HotelFacilityUsage hotelFacilityUsage = new HotelFacilityUsage(id, request.guestName(), request.usageDate(), request.usageTime(), byId.get().getHotel(), byId.get().getFacility());
        HotelFacilityUsage save = hotelFacilityUsageRepository.save(hotelFacilityUsage);

        return new HotelFacilityUsageResponse(save);
    }

    public void delete(Long id) {
        hotelFacilityUsageRepository.deleteById(id);
    }
}
