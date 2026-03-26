package com.example.RoomRentingServiceThesis.service;

import java.util.List;

public interface ReviewService {

    Long createReview(Long roomId, Long renterId, int rating, String comment);

    List<Object> getReviewsByRoom(Long roomId);

    void deleteReview(Long reviewId);
}