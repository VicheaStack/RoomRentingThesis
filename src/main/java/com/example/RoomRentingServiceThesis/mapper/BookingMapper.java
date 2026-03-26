package com.example.RoomRentingServiceThesis.mapper;

import com.example.RoomRentingServiceThesis.dto.BookingResponse;
import com.example.RoomRentingServiceThesis.dto.CreateBookingRequest;
import com.example.RoomRentingServiceThesis.entity.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookingMapper {

    // toResponse: map all fields from the entity
    @Mapping(source = "room.roomId", target = "roomId")
    @Mapping(source = "room.title", target = "roomTitle")
    @Mapping(source = "renter.renterId", target = "renterId")
    @Mapping(target = "renterName", ignore = true)
   // @Mapping(source = "renter.name", target = "renterName")
    // The rest (bookingId, startDate, endDate, totalNights, totalAmount, status, createdAt) are auto‑mapped
    BookingResponse toResponse(Booking booking);


    @Mapping(target = "bookingId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "totalNights", ignore = true)
    @Mapping(target = "pricePerNight", ignore = true)
    @Mapping(target = "totalAmount", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "cancellationReason", ignore = true)
    @Mapping(target = "cancelledAt", ignore = true)
    @Mapping(target = "payment", ignore = true)
    @Mapping(target = "room", ignore = true)      // will be set in service
    @Mapping(target = "renter", ignore = true)
    @Mapping(target = "specialRequests", ignore = true) // will be set in service
    Booking toEntity(CreateBookingRequest dto);
}