package com.example.Theater.Booking.Repository;

import com.example.Theater.Booking.Model.Booking;
import com.example.Theater.Booking.Model.Shows;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking,Long> {
    Booking findByShowId(Shows showId) ;

    List< Booking> findAllByShowId(Shows i);
}
