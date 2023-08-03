package com.example.hotelk.global.domain.entity;

import com.example.hotelk.hotel.domain.entity.HotelRegion;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long regionId;

    private String name;

    @OneToMany(mappedBy = "region")
    private List<HotelRegion> hotels;
    // Getters and Setters
}
