package com.example.RoomRentingServiceThesis.mapper;

import com.example.RoomRentingServiceThesis.entity.Amenity;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface AmenityMapper {
 default List<Long> toIds(List<Amenity> amenities){
        if (amenities == null) return null;
        return amenities.stream()
                    .map(Amenity::getAmenityId)
                    .collect(Collectors.toList());
    }
}