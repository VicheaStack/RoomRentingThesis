package com.example.RoomRentingServiceThesis.service;

import com.example.RoomRentingServiceThesis.entity.Booking;

import java.time.LocalDate;
import java.util.List;

public interface BookingService {

    Long createBooking(Long roomId, Long renterId, LocalDate startDate, LocalDate endDate);

    Booking getBookingById(Long bookingId);

    List<Booking> getBookingsByRenter(Long renterId);

    List<Booking> getBookingsByRoom(Long roomId);

    void cancelBooking(Long bookingId);
}