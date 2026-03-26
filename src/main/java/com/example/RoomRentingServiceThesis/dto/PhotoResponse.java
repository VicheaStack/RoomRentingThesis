package com.example.RoomRentingServiceThesis.dto;

public record PhotoResponse(
        Long photoId,
        Long roomId,
        String photoUrl,
        String caption,
        Boolean isPrimary,
        Integer displayOrder
) {}