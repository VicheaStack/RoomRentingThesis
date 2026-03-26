package com.example.RoomRentingServiceThesis.dto;

import com.example.RoomRentingServiceThesis.entity.Room;

import java.util.List;

public record AmenityResponse(
        Long amenityId,
        String name,
        String description,
        String iconClass,
        String category,
        Boolean isActive,
        List<String> rooms
) {
}