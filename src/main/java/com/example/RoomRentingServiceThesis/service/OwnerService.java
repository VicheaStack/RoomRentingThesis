package com.example.RoomRentingServiceThesis.service;

import com.example.RoomRentingServiceThesis.entity.Owner;

public interface OwnerService {

    Owner createOwner(String fullName, String email, String phoneNumber, String password);

    Owner getOwnerById(Long ownerId);

    void deactivateOwner(Long ownerId);
}