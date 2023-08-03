package com.example.hotelk.global.service;


import com.example.hotelk.config.exception.HotelFacilityNotFoundException;
import com.example.hotelk.config.exception.HotelFacilityUsageNotFoundException;
import com.example.hotelk.config.exception.HotelNotFoundException;
import com.example.hotelk.hotel.domain.entity.Hotel;
import com.example.hotelk.hotel.repository.HotelRepository;
import com.example.hotelk.global.domain.entity.Facility;
import com.example.hotelk.global.repository.FacilityRepository;
import com.example.hotelk.global.domain.entity.FacilityUsage;
import com.example.hotelk.global.domain.request.FacilityUsageRequest;
import com.example.hotelk.global.repository.FacilityUsageRepository;
import com.example.hotelk.global.domain.response.FacilityUsageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class FacilityUsageService {

    private final FacilityUsageRepository hotelFacilityUsageRepository;
    private final HotelRepository hotelRepository;
    private final FacilityRepository hotelFacilityRepository;

    public void insert(FacilityUsageRequest request) {
        Long hotelId = request.hotelId();
        Long facilityId = request.facilityId();

        // Find the Hotel entity from the database based on the provided hotelId
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new HotelNotFoundException("Hotel not found"));

        Facility hotelFacility = hotelFacilityRepository.findById(facilityId).orElseThrow(() -> new HotelFacilityNotFoundException("Facility not found"));

        // Create the HotelFacility entity with the fetched Hotel entity
        FacilityUsage hotelFacilityUsage = FacilityUsage.builder()
                .hotel(hotel).guestName(request.guestName()).facility(hotelFacility)
                .usageDate(request.usageDate()).usageTime(request.usageTime()).build();

        // Save the HotelFacility entity
        hotelFacilityUsageRepository.save(hotelFacilityUsage);
    }

    public Page<FacilityUsageResponse> getAll(PageRequest request) {
        Page<FacilityUsage> all = hotelFacilityUsageRepository.findAll(request);

        return all.map(FacilityUsageResponse::new);
    }

    public FacilityUsageResponse update(Long id, FacilityUsageRequest request) {
        Optional<FacilityUsage> byId = hotelFacilityUsageRepository.findById(id);
        if (byId.isEmpty()) throw new HotelFacilityUsageNotFoundException("NOT FOUND!!");

        FacilityUsage hotelFacilityUsage = new FacilityUsage(id, request.guestName(), request.usageDate(), request.usageTime(), byId.get().getHotel(), byId.get().getFacility());
        FacilityUsage save = hotelFacilityUsageRepository.save(hotelFacilityUsage);

        return new FacilityUsageResponse(save);
    }

    public void delete(Long id) {
        hotelFacilityUsageRepository.deleteById(id);
    }
}
