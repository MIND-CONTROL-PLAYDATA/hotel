package com.example.hotelk.hotelEvent.domain.entity;

import com.example.hotelk.event.domain.entity.Event;
import com.example.hotelk.hotel.domain.entity.Hotel;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class HotelEvent {
    @Id
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @Id
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    // No additional fields as this is a relationship table

    // Getters and Setters
}
