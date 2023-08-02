package com.example.hotelk.amenities.domain.entity;

import com.example.hotelk.hotel.domain.entity.Hotel;
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
public class Amenities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long amenityId;



    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    // Getters and Setters
}
