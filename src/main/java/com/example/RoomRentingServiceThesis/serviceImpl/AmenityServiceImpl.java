package com.example.RoomRentingServiceThesis.serviceImpl;

import com.example.RoomRentingServiceThesis.entity.Amenity;
import com.example.RoomRentingServiceThesis.repository.AmenityRepository;
import com.example.RoomRentingServiceThesis.service.AmenityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmenityServiceImpl implements AmenityService {

    private static final Logger log = LoggerFactory.getLogger(AmenityServiceImpl.class);
    private final AmenityRepository amenityRepository;

    public AmenityServiceImpl(AmenityRepository amenityRepository) {
        this.amenityRepository = amenityRepository;
    }

    @Override
    public Page<Amenity> getAllActiveAmenities(Pageable pageable) {
        log.debug("Fetching active amenities with pagination: page={}, size={}",
                pageable.getPageNumber(), pageable.getPageSize());

        Page<Amenity> activeAmenities = amenityRepository.findByIsActiveTrue(pageable);

        log.debug("Found {} active amenities out of {} total",
                activeAmenities.getNumberOfElements(), activeAmenities.getTotalElements());

        return activeAmenities;
    }
}
