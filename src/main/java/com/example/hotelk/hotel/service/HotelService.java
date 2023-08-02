package com.example.hotelk.hotel.service;

import com.example.hotelk.hotel.domain.entity.Hotel;
import com.example.hotelk.hotel.domain.repository.HotelRepository;
import com.example.hotelk.hotel.domain.request.HotelRequest;
import com.example.hotelk.hotel.domain.response.HotelResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class HotelService {
    private final HotelRepository hotelRepository;

    public void save(HotelRequest request) {
        hotelRepository.save(request.toEntity());
    }

    public Page<HotelResponse> getAll(PageRequest pageRequest) {
        Page<Hotel> all = hotelRepository.findAll(pageRequest);
        return all.map(h -> new HotelResponse(h));
    }

    public Page<HotelResponse> findByName(String name, PageRequest pageRequest) {
        Page<Hotel> byName = hotelRepository.findByName(name, pageRequest);
        return byName.map(h -> new HotelResponse(h));
    }

    public Page<HotelResponse> findByAddress(String address, PageRequest pageRequest) {
        Page<Hotel> byAddress = hotelRepository.findByAddress(address, pageRequest);
        return byAddress.map(h -> new HotelResponse(h));
    }

    public HotelResponse update(Long hotelId, HotelRequest hotelRequest) {
        Optional<Hotel> byId = hotelRepository.findById(hotelId);
        if (byId.isEmpty()) throw new RuntimeException("없는 호텔 정보를 수정하려합니다.");
        Hotel hotel = new Hotel(
                hotelId, hotelRequest.getName(), hotelRequest.getDescription(), hotelRequest.getAddress(), hotelRequest.getPhoneNumber()
                , hotelRequest.getEmail(), hotelRequest.getUrl(),null, null, null);
        Hotel save = hotelRepository.save(hotel);
        return new HotelResponse(save);
    }
    public void delete(Long hotelId) {
        hotelRepository.deleteById(hotelId);
    }

}
