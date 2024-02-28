package com.example.Theater.Booking.repository;


import com.example.Theater.Booking.model.Screen;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ScreenRepository extends MongoRepository<Screen, Integer> {
}
