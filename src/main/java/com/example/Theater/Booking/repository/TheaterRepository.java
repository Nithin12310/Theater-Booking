package com.example.Theater.Booking.repository;


import com.example.Theater.Booking.model.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<Theater, Long> {
}
