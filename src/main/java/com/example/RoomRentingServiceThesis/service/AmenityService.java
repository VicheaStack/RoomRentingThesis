package com.example.RoomRentingServiceThesis.service;

import com.example.RoomRentingServiceThesis.entity.Amenity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AmenityService {

    Page<Amenity> getAllActiveAmenities(Pageable pageable);

}