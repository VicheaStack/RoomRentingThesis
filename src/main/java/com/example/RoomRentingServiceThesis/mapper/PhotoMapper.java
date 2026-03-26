package com.example.RoomRentingServiceThesis.mapper;


import com.example.RoomRentingServiceThesis.dto.PhotoResponse;
import com.example.RoomRentingServiceThesis.entity.Photo;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface PhotoMapper {

    default List<Long> toIds(List<Photo> photos){
        if (photos == null) return null;
        return photos.stream()
                .map(Photo::getPhotoId)
                .collect(Collectors.toList());
    }
}