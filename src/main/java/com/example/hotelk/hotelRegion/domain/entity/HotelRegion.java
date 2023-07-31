package com.example.hotelk.hotelRegion.domain.entity;

import com.example.hotelk.hotel.domain.entity.Hotel;
import com.example.hotelk.region.domain.entity.Region;
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
public class HotelRegion {
    @Id
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @Id
    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    // No additional fields as this is a relationship table

    // Getters and Setters
}
