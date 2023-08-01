package com.example.hotelk;

import com.example.hotelk.reservation.controller.ReservationController;
import com.example.hotelk.reservation.domain.entity.Reservation;
import com.example.hotelk.reservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;


@SpringBootApplication
public class HotelkApplication {
	public static void main(String[] args) {
		SpringApplication.run(HotelkApplication.class, args);
	}

}
