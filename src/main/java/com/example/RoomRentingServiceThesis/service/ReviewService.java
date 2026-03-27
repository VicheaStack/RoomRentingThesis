package com.example.RoomRentingServiceThesis.service;

import com.example.RoomRentingServiceThesis.entity.Review;

import java.util.List;

public interface ReviewService {

    Long createReview(Long roomId, Long renterId, int rating, String comment);

    List<Review> getReviewsByRoom(Long roomId);

    void deleteReview(Long reviewId);
}