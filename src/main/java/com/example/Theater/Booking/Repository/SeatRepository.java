package com.example.Theater.Booking.Repository;

import com.example.Theater.Booking.Model.Booking;
import com.example.Theater.Booking.Model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat,Long> {
    List<Seat> findByBookingId(Booking i);
}