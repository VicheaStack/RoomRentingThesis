package com.example.RoomRentingServiceThesis.dto;

public record CreateRenterRequest(
    String fullName,
    String email,
    String phoneNumber,
    String password
) {}