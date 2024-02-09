package com.example.Theater.Booking.Repository;

import com.example.Theater.Booking.Model.LinkTypeOffer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkTypeOfferRepository extends MongoRepository<LinkTypeOffer,String> {
    LinkTypeOffer getFirstByPublish(Boolean isPublish);
}
