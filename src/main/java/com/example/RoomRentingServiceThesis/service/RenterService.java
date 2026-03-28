package com.example.RoomRentingServiceThesis.service;

import com.example.RoomRentingServiceThesis.entity.Renter;

public interface RenterService {

    Renter createRenter(String fullName, String email, String phone, String password);

    Renter getRenterById(Long renterId);

    Renter updateRenter(Long renterId, String fullName, String email, String phone);

    void deactivateRenter(Long renterId);
}