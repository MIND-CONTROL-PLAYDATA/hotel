package com.example.hotelk.reservation.repository;

import com.example.hotelk.reservation.domain.entity.Reservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Page<Reservation> findAllByGuestName(String name, Pageable pageable);

    Page<Reservation> findAllBy(Pageable pageable);
}
