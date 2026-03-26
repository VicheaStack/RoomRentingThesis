package com.example.RoomRentingServiceThesis.service;

import java.util.List;

public interface NotificationService {

    List<Object> getUserNotifications(Long userId, String userType);

    void markAsRead(Long notificationId);
}