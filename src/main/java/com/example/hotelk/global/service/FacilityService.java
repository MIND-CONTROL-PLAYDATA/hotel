package com.example.hotelk.global.service;

import com.example.hotelk.config.exception.HotelFacilityNotFoundException;
import com.example.hotelk.config.exception.HotelNotFoundException;
import com.example.hotelk.hotel.domain.entity.Hotel;
import com.example.hotelk.hotel.repository.HotelRepository;
import com.example.hotelk.global.domain.entity.Facility;
import com.example.hotelk.global.domain.request.FacilityRequest;
import com.example.hotelk.global.domain.response.FacilityResponse;
import com.example.hotelk.global.repository.FacilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class FacilityService {

    private final FacilityRepository hotelFacilityRepository;
    private final HotelRepository hotelRepository;
    public void insert(FacilityRequest request) {
        Long hotelId = request.hotelId();

        // Find the Hotel entity from the database based on the provided hotelId
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new HotelNotFoundException("Hotel not found"));

        // Create the HotelFacility entity with the fetched Hotel entity
        Facility hotelFacility = Facility.builder()
                .hotel(hotel)
                .name(request.name())
                .description(request.description())
                .build();

        // Save the HotelFacility entity
        hotelFacilityRepository.save(hotelFacility);
    }

    public Page<FacilityResponse> getAll(String name, PageRequest request) {
        Page<Facility> all = hotelFacilityRepository.findAllByNameContaining(name, request);
        return all.map(FacilityResponse::new);
    }

    public FacilityResponse update(Long id, FacilityRequest request) {
        Optional<Facility> byId = hotelFacilityRepository.findById(id);
        if (byId.isEmpty()) throw new HotelFacilityNotFoundException("HOTEL FACILITY NOT FOUND!!");

        Facility hotelFacility = new Facility(id, request.name(), request.description(), byId.get().getHotel());
        Facility save = hotelFacilityRepository.save(hotelFacility);

        return new FacilityResponse(save);
    }

    public void delete(Long id) {
        hotelFacilityRepository.deleteById(id);
    }
}
