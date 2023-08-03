package com.example.hotelk.reservation.service;

import com.example.hotelk.reservation.domain.entity.Reservation;
import com.example.hotelk.reservation.domain.request.ReservationRequest;
import com.example.hotelk.reservation.domain.response.ReservationResponse;
import com.example.hotelk.reservation.repository.ReservationRepository;
import com.example.hotelk.room.domain.entity.Room;
import com.example.hotelk.room.repository.RoomRepository;
import com.example.hotelk.user.domain.entity.User;
import com.example.hotelk.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;
    private final UserRepository userRepository;

    public void save(ReservationRequest request) {

        Room room = roomRepository.findById(request.getRoomId())
                .orElseThrow(()-> new RuntimeException("Room not found"));
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(()-> new RuntimeException("User not found"));

        double testPrice = ChronoUnit.DAYS.between(request.getCheckInDate(), request.getCheckOutDate()); //totalPrice 계산
        double totalPrice = testPrice * room.getPrice();
        System.out.println();
        Reservation reservation = Reservation.builder()
                .room(room)
                .guestName(request.getGuestName())
                .checkInDate(request.getCheckInDate())
                .checkOutDate(request.getCheckOutDate())
                .totalPrice(totalPrice)
                .people(request.getPeople())
                .poneNumber(request.getPoneNumber())
                .user(user)
                .build();

        reservationRepository.save(reservation);
    }

    public Reservation findById(Long id) {
        Optional<Reservation> byId = reservationRepository.findById(id);
        return byId.orElseThrow(()->
                new RuntimeException("없는 예약입니다."));
    }


    public ReservationResponse changeDate(Long id,ReservationRequest request) {
        Optional<Reservation> byId = reservationRepository.findById(id);
        if (byId.isEmpty()) throw new RuntimeException("예약이 없습니다.");

        Room room = roomRepository.findById(request.getRoomId()).orElseThrow();
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        Reservation reservation = new Reservation(id, room, request.getGuestName(), request.getCheckInDate(), request.getCheckOutDate(),
                byId.get().getTotalPrice(), request.getPeople(), request.getPoneNumber(), user);
        Reservation save = reservationRepository.save(reservation);
        return new ReservationResponse(save);

    }

    public void deleteById(Long id) {
        reservationRepository.deleteById(id);
    }
    public Page<ReservationResponse> findByName(String name, PageRequest request) {
        Page<Reservation> all = reservationRepository.findAllByGuestName(name, request);
        return all.map(r-> new ReservationResponse(r));
    }
    public Page<ReservationResponse> findAll(Pageable pageable) {
        Page<Reservation> allBy = reservationRepository.findAllBy(pageable);
        return allBy.map(m-> new ReservationResponse(m));
    }




}
