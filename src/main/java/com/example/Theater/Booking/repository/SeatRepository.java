package com.example.Theater.Booking.repository;

import com.example.Theater.Booking.model.Booking;
import com.example.Theater.Booking.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findByBookingId(Booking i);
}