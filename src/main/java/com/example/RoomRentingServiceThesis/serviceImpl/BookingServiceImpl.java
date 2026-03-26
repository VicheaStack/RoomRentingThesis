package com.example.RoomRentingServiceThesis.serviceImpl;

import com.example.RoomRentingServiceThesis.entity.Booking;
import com.example.RoomRentingServiceThesis.entity.Renter;
import com.example.RoomRentingServiceThesis.entity.Room;
import com.example.RoomRentingServiceThesis.repository.BookingRepository;
import com.example.RoomRentingServiceThesis.repository.RenterRepository;
import com.example.RoomRentingServiceThesis.repository.RoomRepository;
import com.example.RoomRentingServiceThesis.service.BookingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;


@Transactional
@Service
@Slf4j
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;
    private final RenterRepository renterRepository;

    public BookingServiceImpl(BookingRepository bookingRepository,
                              RoomRepository roomRepository,
                              RenterRepository renterRepository) {
        this.bookingRepository = bookingRepository;
        this.roomRepository = roomRepository;
        this.renterRepository = renterRepository;
    }

    @Override
    public Long createBooking(Long roomId, Long renterId, LocalDate startDate, LocalDate endDate) {

        if(startDate == null || endDate == null ) throw new IllegalArgumentException("Start date and End data can't be empty: ");

        if(startDate.isAfter(endDate) ||  endDate.isEqual(endDate)) throw new IllegalArgumentException("End data must be after start date: ");

        Room booking = roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found with id " + roomId));

        Renter renter = renterRepository.findById(renterId)
                .orElseThrow(() -> new RuntimeException("Renter not found with id: " + renterId));

        List<Booking> overlappingBookings = bookingRepository.findOverlappingBookings(roomId, startDate, endDate);

        if(!overlappingBookings.isEmpty()) throw new IllegalArgumentException("room is already booking with select date: " + startDate + endDate);

        Booking created = new Booking();
        created.setRoom(booking);
        created.setRenter(renter);
        created.setStartDate(startDate);
        created.setEndDate(endDate);
        created.setStatus("PENDING");

        Booking save = bookingRepository.save(created);
        return save.getBookingId();
    }

    @Override
    public Booking getBookingById(Long bookingId) {
        log.debug("Fetching booking by id: {}", bookingId);
        return bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("can't find booking"));
    }

    @Override
    public List<Booking> getBookingsByRenter(Long renterId) {
        Renter renter = renterRepository.findById(renterId)
                .orElseThrow(() -> new RuntimeException("Can't find renter: " + renterId));
        return renter.getBookings();
    }

    @Override
    public List<Booking> getBookingsByRoom(Long roomId) {
        log.debug("Fetching bookings for room: {}", roomId);
        Booking booking = bookingRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("can't find Booking room: " + roomId));
        return bookingRepository.findByRoom_RoomId(roomId);
    }

    @Override
    public void cancelBooking(Long bookingId) {
        log.info("Cancelling booking with id: {}", bookingId);
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found with id: " + bookingId));
        if ("CANCELLED".equals(booking.getStatus())) {
            throw new IllegalStateException("Booking is already cancelled");
        }
        booking.setStatus("CANCELLED");
        bookingRepository.save(booking);
        log.info("Booking {} cancelled", bookingId);
    }
}
