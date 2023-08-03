package com.example.hotelk.hotelFacility.service;

import com.example.hotelk.config.exception.HotelFacilityNotFoundException;
import com.example.hotelk.config.exception.HotelNotFoundException;
import com.example.hotelk.hotel.domain.entity.Hotel;
import com.example.hotelk.hotel.domain.repository.HotelRepository;
import com.example.hotelk.hotelFacility.domain.entity.HotelFacility;
import com.example.hotelk.hotelFacility.domain.request.HotelFacilityRequest;
import com.example.hotelk.hotelFacility.domain.response.HotelFacilityResponse;
import com.example.hotelk.hotelFacility.repository.HotelFacilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class HotelFacilityService {

    private final HotelFacilityRepository hotelFacilityRepository;
    private final HotelRepository hotelRepository;
    public void insert(HotelFacilityRequest request) {
        Long hotelId = request.hotelId();

        // Find the Hotel entity from the database based on the provided hotelId
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new HotelNotFoundException("Hotel not found"));

        // Create the HotelFacility entity with the fetched Hotel entity
        HotelFacility hotelFacility = HotelFacility.builder()
                .hotel(hotel)
                .name(request.name())
                .description(request.description())
                .build();

        // Save the HotelFacility entity
        hotelFacilityRepository.save(hotelFacility);
    }

    public Page<HotelFacilityResponse> getAll(String name, PageRequest request) {
        Page<HotelFacility> all = hotelFacilityRepository.findAllByNameContaining(name, request);
        return all.map(HotelFacilityResponse::new);
    }

    public HotelFacilityResponse update(Long id, HotelFacilityRequest request) {
        Optional<HotelFacility> byId = hotelFacilityRepository.findById(id);
        if (byId.isEmpty()) throw new HotelFacilityNotFoundException("HOTEL FACILITY NOT FOUND!!");

        HotelFacility hotelFacility = new HotelFacility(id, byId.get().getHotel(), request.name(), request.description());
        HotelFacility save = hotelFacilityRepository.save(hotelFacility);

        return new HotelFacilityResponse(save);
    }

    public void delete(Long id) {
        hotelFacilityRepository.deleteById(id);
    }
}
