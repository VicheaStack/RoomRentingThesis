package com.example.RoomRentingServiceThesis.dto;

import java.util.List;

public record CreateRoomRequest(
    Long ownerId,
    String title,
    String description,
    Double pricePerMonth,
    String location,
    Double latitude,
    Double longitude,
    String roomType,
    Integer maxOccupancy,
    Boolean hasPrivateBathroom,
    Boolean isFurnished,
    List<Long> amenityIds
) {}