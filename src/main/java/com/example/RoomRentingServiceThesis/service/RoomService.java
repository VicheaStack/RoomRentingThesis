package com.example.RoomRentingServiceThesis.service;

import com.example.RoomRentingServiceThesis.entity.Room;

import java.util.List;

public interface RoomService {

    Long createRoom(Long ownerId, String title, String description, double price, String location);

    Room getRoomById(Long roomId);

    List<Room> searchRooms(String location, Double minPrice, Double maxPrice, String roomType, Boolean verified);

    void deleteRoom(Long roomId);
}