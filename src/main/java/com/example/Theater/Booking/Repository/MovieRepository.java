package com.example.Theater.Booking.Repository;


import com.example.Theater.Booking.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Long> {
}
