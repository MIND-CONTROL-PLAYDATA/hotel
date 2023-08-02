package com.example.hotelk.hotel.domain.entity;

import com.example.hotelk.hotel.domain.entity.Hotel;
import com.example.hotelk.region.domain.entity.Region;
import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    private Hotel hotel;


    @ManyToOne
    private Region region;

    // No additional fields as this is a relationship table

    // Getters and Setters
}
