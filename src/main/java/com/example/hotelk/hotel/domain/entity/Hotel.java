package com.example.hotelk.hotel.domain.entity;

import com.example.hotelk.amenities.domain.entity.Amenities;
import com.example.hotelk.hotelFacility.domain.entity.HotelFacility;
import com.example.hotelk.hotelFacilityUsage.domain.entity.HotelFacilityUsage;
import com.example.hotelk.hotelRegion.domain.entity.HotelRegion;
import com.example.hotelk.room.domain.entity.Room;
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
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hotelId;

    private String name;
    private String description;
    private String address;
    private String phoneNumber;
    private String email;
    private String url;

    @OneToMany(mappedBy = "hotel")
    private List<Room> room;
    @OneToMany(mappedBy = "hotel")
    private List<HotelPromotion> promotions;
    @OneToMany(mappedBy = "hotel")
    private List<AvgRating> avgRatings;

    @OneToMany(mappedBy = "hotel")
    private List<HotelRegion> regions;

    @OneToMany(mappedBy = "hotel")
    private List<Amenities> amenities;

    @OneToMany(mappedBy = "hotel")
    private List<HotelFacility> hotelFacilities;


    @OneToMany(mappedBy = "hotel")
    private List<HotelFacilityUsage> hotelFacilityUsages;
}
