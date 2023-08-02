package com.example.hotelk.hotelFacilityUsage.domain.entity;

import com.example.hotelk.hotel.domain.entity.Hotel;
import com.example.hotelk.hotelFacility.domain.entity.HotelFacility;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class HotelFacilityUsage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usageId;

    private String guestName;

    private Timestamp usageDate;
    private Timestamp usageTime;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
    @ManyToOne
    @JoinColumn(name = "facility_id")
    private HotelFacility facility;

    // Getters and Setters
}
