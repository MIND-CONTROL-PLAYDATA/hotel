package com.example.hotelk.reservation.service;

import com.example.hotelk.reservation.domain.entity.Reservation;
import com.example.hotelk.reservation.domain.request.ReservationRequest;
import com.example.hotelk.reservation.domain.response.ReservationResponse;
import com.example.hotelk.reservation.repository.ReservationRepository;
import com.example.hotelk.room.domain.entity.Room;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ReservationService {

    private final ReservationRepository repository;

    public void save(ReservationRequest request) {
        repository.save(request.toEntity());
    }

    public Reservation findById(Long id) {
        Optional<Reservation> byId = repository.findById(id);
        return byId.orElseThrow(()->
                new RuntimeException("없는 예약입니다."));
    }


    public ReservationResponse changeDate(Long id,ReservationRequest request) {
        Optional<Reservation> byId = repository.findById(id);
        if (byId.isEmpty()) throw new RuntimeException("없는 예약입니다.");
        Reservation reservation =
                new Reservation(id, null, request.getGuestName() , request.getCheckInDate(), request.getCheckOutDate()
                        , request.getTotalPrice(), request.getPeople(), null, request.getPoneNumber(), null);
        Reservation save = repository.save(reservation);
        return new ReservationResponse(save);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    public Page<ReservationResponse> findByName(String name, PageRequest request) {
        Page<Reservation> all = repository.findAllByGuestName(name, request);
        return all.map(r-> new ReservationResponse(r));
    }
    public Page<ReservationResponse> findAll(Pageable pageable) {
        Page<Reservation> allBy = repository.findAllBy(pageable);
        return allBy.map(m-> new ReservationResponse(m));
    }


}
