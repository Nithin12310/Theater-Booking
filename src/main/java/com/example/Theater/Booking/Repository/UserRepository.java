package com.example.Theater.Booking.Repository;

import com.example.Theater.Booking.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}