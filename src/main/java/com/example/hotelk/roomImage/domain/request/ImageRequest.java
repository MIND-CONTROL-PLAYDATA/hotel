package com.example.hotelk.roomImage.domain.request;

import com.example.hotelk.room.domain.entity.Room;
import com.example.hotelk.roomImage.domain.entity.RoomImage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ImageRequest {
    private String url;

    public RoomImage toEntity(ImageRequest request, Room room){
        return RoomImage.builder()
                .imageId(null)
                .room(room)
                .url(request.getUrl())
                .build();
    }
}
