package com.example.hotelk.global.domain.entity;

import com.example.hotelk.hotel.domain.entity.HotelPromotion;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long promotionId;

    private String title;
    private String description;
    private Timestamp startDate;
    private Timestamp endDate;

    @OneToMany(mappedBy = "promotion")
    private List<HotelPromotion> hotels;

}
