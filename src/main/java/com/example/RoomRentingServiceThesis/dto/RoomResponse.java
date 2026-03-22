package com.example.RoomRentingServiceThesis.dto;

import java.time.LocalDateTime;
import java.util.List;

public record RoomResponse(
    Long roomId,
    String title,
    String description,
    Double pricePerMonth,
    String location,
    Double latitude,
    Double longitude,
    String roomType,
    String status,
    Integer sizeSqft,
    Integer maxOccupancy,
    Boolean hasPrivateBathroom,
    Boolean isFurnished,
    Boolean isVerified,
    Integer totalViews,
    Integer totalBookings,
    Double averageRating,
    OwnerSummary owner,
    List<String> amenities,
    List<String> photos,
    LocalDateTime createdAt
) {}