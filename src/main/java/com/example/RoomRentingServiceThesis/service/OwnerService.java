package com.example.RoomRentingServiceThesis.service;

public interface OwnerService {

    void createOwner(String fullName, String email, String phone, String password);

    Object getOwnerById(Long ownerId);

    void deactivateOwner(Long ownerId);
}