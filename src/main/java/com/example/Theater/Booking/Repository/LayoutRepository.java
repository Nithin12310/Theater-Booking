package com.example.Theater.Booking.Repository;


import com.example.Theater.Booking.Model.Layouts;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LayoutRepository extends MongoRepository<Layouts,String> {
    Layouts findByTheaterIdAndScreenId(Long theaterId, Long screenId);
}
