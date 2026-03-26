package com.example.RoomRentingServiceThesis.service;

import java.util.List;

public interface RoomService {

    Long createRoom(Long ownerId, String title, String description, double price, String location);

    Object getRoomById(Long roomId);

    List<Object> searchRooms(String location, Double minPrice, Double maxPrice, String roomType, Boolean verified);

    void deleteRoom(Long roomId);
}