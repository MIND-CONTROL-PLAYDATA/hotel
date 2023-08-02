package com.example.hotelk.hotel.domain.entity;

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
    @Builder.Default
    private Double totalRate = 0.0;
    @Builder.Default
    private Double numCommentPeople = 0.0;

    @OneToMany(mappedBy = "hotel")
    private List<HotelRoom> rooms;
    @OneToMany(mappedBy = "hotel")
    private List<HotelPromotion> promotions;

}
