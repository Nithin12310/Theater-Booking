package com.example.Theater.Booking.repository;

import com.example.Theater.Booking.model.Offers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OffersRepository extends JpaRepository<Offers, String> {
    List<Offers> findByrewardType(String rewardType);
}
