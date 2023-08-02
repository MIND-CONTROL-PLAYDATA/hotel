package com.example.hotelk.hotel.domain.request;

import com.example.hotelk.hotel.domain.entity.Hotel;
import com.example.hotelk.hotel.domain.entity.Promotion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PromotionRequest {
    private String title;
    private String description;
    private Timestamp startDate;
    private Timestamp endDate;
    private Long hotelId;

    public Promotion toEntity() {
        return Promotion
                .builder()
                .title(title)
                .description(description)
                .startDate(startDate)
                .endDate(endDate)
                .build();
    }


}



