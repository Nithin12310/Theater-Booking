package com.example.Theater.Booking.Repository;



import com.example.Theater.Booking.Model.Screen;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ScreenRepository extends MongoRepository<Screen,Integer> {
}
