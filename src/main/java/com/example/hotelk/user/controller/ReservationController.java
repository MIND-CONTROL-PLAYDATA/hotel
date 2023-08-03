package com.example.hotelk.user.controller;

import com.example.hotelk.user.domain.entity.Reservation;
import com.example.hotelk.user.domain.request.ReservationRequest;
import com.example.hotelk.user.domain.response.ReservationResponse;
import com.example.hotelk.user.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.time.temporal.ChronoUnit;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/reservation")
public class ReservationController {
    private final ReservationService reservationService;

    @PostMapping
    public void insert(@RequestBody ReservationRequest request) {
        reservationService.save(request);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") Long id) {
        reservationService.deleteById(id);
    }

    @GetMapping("{id}")
    public Reservation getById(@PathVariable("id") Long id) {
        return reservationService.findById(id);
    }

    /*@GetMapping
    public Page<ReservationResponse> findName(
            @RequestParam(name = "name", required = false, defaultValue = "") String name,
            @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page) {
        PageRequest request = PageRequest.of(page, size);
        return reservationService.findByName(name, request);
    }*/
    @GetMapping
    public Page<ReservationResponse> findAll(
            @RequestParam(name = "size", required = false, defaultValue = "10") Integer size,
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page) {
        PageRequest request = PageRequest.of(page, size);
        return reservationService.findAll(request);
    }

    @PutMapping("{id}")
    public void changeData(@PathVariable("id") Long id,
                           @RequestBody ReservationRequest request) {
        reservationService.changeDate(id, request);

    }

    //totalPrice
    @GetMapping("/price")
    public void price() {
        Reservation byId = reservationService.findById(1L);
        System.out.println(ChronoUnit.DAYS.between(byId.getCheckInDate(), byId.getCheckOutDate()));
    }


}
