package com.example.RoomRentingServiceThesis.serviceImpl;

import com.example.RoomRentingServiceThesis.entity.Review;
import com.example.RoomRentingServiceThesis.repository.RenterRepository;
import com.example.RoomRentingServiceThesis.repository.ReviewRepository;
import com.example.RoomRentingServiceThesis.service.RenterService;
import com.example.RoomRentingServiceThesis.service.ReviewService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class RenterServiceImpl implements RenterService {

    private final ReviewRepository reviewRepository;
    private final RenterRepository renterRepository;

    public RenterServiceImpl(ReviewRepository reviewRepository,
                             RenterRepository renterRepository) {
        this.reviewRepository = reviewRepository;
        this.renterRepository = renterRepository;
    }

    @Override
    public void createRenter(String fullName, String email, String phone, String password) {

    }

    @Override
    public Object getRenterById(Long renterId) {
        return null;
    }

    @Override
    public void updateRenter(Long renterId, String fullName, String email, String phone) {

    }

    @Override
    public void deactivateRenter(Long renterId) {

    }
}
