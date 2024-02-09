package com.example.Theater.Booking.Repository;


import com.example.Theater.Booking.Model.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<Theater,Long> {
}
