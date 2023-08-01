package com.example.hotelk.roomImage.domain.entity;

import com.example.hotelk.hotel.domain.entity.Hotel;
import com.example.hotelk.room.domain.entity.Room;
import com.example.hotelk.roomImage.domain.request.ImageRequest;
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
public class RoomImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageId;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    private String url;

    public void update(ImageRequest request){
        this.url = request.getUrl();
    }
}
