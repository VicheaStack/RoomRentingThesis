package com.example.RoomRentingServiceThesis.dto;

import java.time.LocalDateTime;

public record NotificationResponse(
    Long notificationId,
    Long userId,
    String userType,
    String type,
    String title,
    String message,
    Boolean isRead,
    LocalDateTime createdAt
) {}