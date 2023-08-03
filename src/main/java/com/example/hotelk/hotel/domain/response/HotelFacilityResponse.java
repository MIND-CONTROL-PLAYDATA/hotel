package com.example.hotelk.hotel.domain.response;

import com.example.hotelk.global.domain.entity.Facility;
import com.example.hotelk.hotel.domain.entity.Hotel;
import com.example.hotelk.hotel.domain.entity.HotelFacility;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

import java.util.List;

@Getter
public class HotelFacilityResponse {

    private List<HotelDto> hotels;

    private List<FacilityDto> facility;

    public HotelFacilityResponse(HotelFacility hotelFacility) {
        this.hotels = hotelFacility.getFacility().getHotels().stream().map(HotelFacility::getHotel).map(HotelDto::new).toList();
        this.facility = hotelFacility.getHotel().getHotelFacilities().stream().map(HotelFacility::getFacility).map(FacilityDto::new).toList();
    }

    @Getter
    class FacilityDto {
        private Long facilityId;


        private String name;
        private String description;


        public FacilityDto(Facility hotelFacility) {
            this.facilityId = hotelFacility.getFacilityId();
            this.name = hotelFacility.getName();
            this.description = hotelFacility.getDescription();
        }
    }

    @Getter
    class HotelDto {
        private Long hotelId;

        private String name;
        private String description;
        private String address;
        private String phoneNumber;
        private String email;
        private String url;

        public HotelDto(Hotel hotel) {
            this.hotelId = hotel.getHotelId();
            this.name = hotel.getName();
            this.description = hotel.getDescription();
            this.address = hotel.getAddress();
            this.phoneNumber = hotel.getPhoneNumber();
            this.email = hotel.getEmail();
            this.url = hotel.getUrl();
        }
    }
}
