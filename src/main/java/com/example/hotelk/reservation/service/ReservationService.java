package com.example.hotelk.reservation.service;

import com.example.hotelk.reservation.domain.entity.Reservation;
import com.example.hotelk.reservation.domain.request.ReservationRequest;
import com.example.hotelk.reservation.domain.response.ReservationResponse;
import com.example.hotelk.reservation.repository.ReservationRepository;
import com.example.hotelk.room.domain.entity.Room;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository repository;

    public void save(ReservationRequest request) {
        repository.save(request.toEntity());
    }


    public Reservation findById(Long id) {
        Optional<Reservation> byId = repository.findById(id);
        return byId.orElseThrow(()->
                new RuntimeException("없는 예약입니다."));
//        return new ReservationResponse(reservation);
    }


    /*public Reservation update(Long id,ReservationRequest request) {
        Reservation reservation = repository.findById(id).get();
        reservation.
    }*/

    public void deleteById(Long id) {
        repository.deleteById(id);
    }



}
