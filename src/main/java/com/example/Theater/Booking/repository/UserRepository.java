package com.example.Theater.Booking.repository;

import com.example.Theater.Booking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}