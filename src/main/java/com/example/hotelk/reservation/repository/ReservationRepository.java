package com.example.hotelk.reservation.repository;

import com.example.hotelk.reservation.domain.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
