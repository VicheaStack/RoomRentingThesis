package com.example.RoomRentingServiceThesis.service;

import java.util.List;

public interface PhotoService {

    List<Object> getPhotosByRoom(Long roomId);

}