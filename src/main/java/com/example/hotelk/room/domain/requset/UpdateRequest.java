package com.example.hotelk.room.domain.requset;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRequest {
    private String name;
    private String type;
    private Double price;
    private Integer capacity;
    private String description;
}
