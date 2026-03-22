package com.example.RoomRentingServiceThesis.dto;

public record UpdateRenterRequest(
    String fullName,
    String phoneNumber,
    String profilePhotoUrl
) {}