package com.example.hotelk.hotel.domain.entity;

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

}
