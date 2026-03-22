package com.example.RoomRentingServiceThesis.dto;

public record FavoriteResponse(
    Long favoriteId,
    Long renterId,
    Long roomId
) {}