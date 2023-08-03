package com.example.hotelk.global.domain.entity;

import com.example.hotelk.hotel.domain.entity.Hotel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class FacilityUsage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usageId;

    private String guestName;


    @CreationTimestamp
    private LocalDate usageDate;


    private LocalTime usageTime;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "facility_id")
    private Facility facility;

    // Getters and Setters
}
