package com.example.Theater.Booking.repository;


import com.example.Theater.Booking.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
