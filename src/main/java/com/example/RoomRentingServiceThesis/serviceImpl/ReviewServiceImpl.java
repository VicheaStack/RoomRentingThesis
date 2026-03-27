package com.example.RoomRentingServiceThesis.serviceImpl;

import com.example.RoomRentingServiceThesis.entity.Renter;
import com.example.RoomRentingServiceThesis.entity.Review;
import com.example.RoomRentingServiceThesis.entity.Room;
import com.example.RoomRentingServiceThesis.repository.RenterRepository;
import com.example.RoomRentingServiceThesis.repository.ReviewRepository;
import com.example.RoomRentingServiceThesis.repository.RoomRepository;
import com.example.RoomRentingServiceThesis.service.ReviewService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final RenterRepository renterRepository;
    private final RoomRepository roomRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository,
                             RenterRepository renterRepository,
                             RoomRepository roomRepository) {
        this.reviewRepository = reviewRepository;
        this.renterRepository = renterRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    public Long createReview(Long roomId, Long renterId, int rating, String comment) {

        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }
        if (comment == null || comment.isBlank()) {
            throw new IllegalArgumentException("Comment cannot be empty");
        }

        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found" + roomId));

        Renter renter = renterRepository.findById(renterId)
                .orElseThrow(() -> new RuntimeException("Renter not found" + renterId));

        Review review = new Review();
        review.setRoom(room);
        review.setRenter(renter);
        review.setRating(rating);
        review.setComment(comment);

        Review save = reviewRepository.save(review);
        return save.getReviewId();
    }

    @Override
    public List<Review> getReviewsByRoom(Long roomId) {
        if (!roomRepository.existsById(roomId)) {
            throw new EntityNotFoundException("Room not found: " + roomId);
        }
        return reviewRepository.findByRoom_RoomId(roomId);
    }

    @Override
    public void deleteReview(Long reviewId) {
        if(!reviewRepository.existsById(reviewId)){
            throw new RuntimeException("Review not found: " + reviewId);
        }
        reviewRepository.deleteById(reviewId);
    }
}
