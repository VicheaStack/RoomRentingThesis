package com.example.RoomRentingServiceThesis.dto;

public record CreateOwnerRequest(
    String fullName,
    String email,
    String phoneNumber,
    String password
) {}