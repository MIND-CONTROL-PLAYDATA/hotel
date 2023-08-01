package com.example.hotelk.reservation.controller;

import com.example.hotelk.reservation.domain.entity.Reservation;
import com.example.hotelk.reservation.domain.request.ReservationRequest;
import com.example.hotelk.reservation.domain.response.ReservationResponse;
import com.example.hotelk.reservation.service.ReservationService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.PanelUI;

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

}
