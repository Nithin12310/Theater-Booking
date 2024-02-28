package com.example.Theater.Booking.repository;

import com.example.Theater.Booking.model.Booking;
import com.example.Theater.Booking.model.Shows;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    Booking findByShowId(Shows showId);

    List<Booking> findAllByShowId(Shows i);
}
