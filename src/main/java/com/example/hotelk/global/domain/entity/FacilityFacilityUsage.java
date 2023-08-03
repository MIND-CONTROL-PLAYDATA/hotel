package com.example.hotelk.global.domain.entity;

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
@Table(name = "facility_facilityusage")
public class FacilityFacilityUsage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "facility_id")
    private Facility facility;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usage_id")
    private FacilityUsage facilityUsage;
}
