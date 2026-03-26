package com.example.RoomRentingServiceThesis.service;

public interface RenterService {

    void createRenter(String fullName, String email, String phone, String password);

    Object getRenterById(Long renterId);

    void updateRenter(Long renterId, String fullName, String email, String phone);

    void deactivateRenter(Long renterId);
}