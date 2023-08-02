package com.example.hotelk.hotel.domain.response;

import com.example.hotelk.hotel.domain.entity.Hotel;
import com.example.hotelk.hotel.domain.entity.HotelRegion;
import com.example.hotelk.region.domain.entity.Region;
import lombok.Getter;

import java.util.List;

@Getter
public class HotelRegionResponse {

    List<HotelDto> hotels;

    List<RegionDto> regions;

    public HotelRegionResponse(HotelRegion hotelRegion) {
        this.hotels = hotelRegion.getRegion().getHotels().stream().map(HotelRegion::getHotel).map(HotelDto::new).toList();
        this.regions = hotelRegion.getHotel().getRegions().stream().map(HotelRegion::getRegion).map(RegionDto::new).toList();
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

    @Getter
    class RegionDto {
        private Long regionId;

        private String name;

        public RegionDto(Region region) {
            this.regionId = region.getRegionId();
            this.name = region.getName();
        }
    }
}
