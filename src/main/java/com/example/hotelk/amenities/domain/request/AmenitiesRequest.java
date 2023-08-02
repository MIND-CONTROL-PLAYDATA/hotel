package com.example.hotelk.amenities.domain.request;

import com.example.hotelk.amenities.domain.entity.Amenities;
import com.example.hotelk.hotel.domain.entity.Hotel;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public record AmenitiesRequest(Long hotelId,String name,String description) {


}
